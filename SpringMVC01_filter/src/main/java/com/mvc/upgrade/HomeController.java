package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	
	//home.do로 들어오면 처리를 아래 메소드가 처리하는 것이다.
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//기본적으로 제공하는 메소드들.
		logger.info("Welcome home! The client locale is {}.", locale); // log관련
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// list.do 로 요청이 들어오면 해당 메소드가 처리해줄 것 이다.
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		model.addAttribute("list",biz.selectList());
		return "mvclist";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		//필드명이랑 form태그 명이랑 같아야한다.
		logger.info("INSERT RES");
		int res = biz.insert(dto);
		if(res>0) {
			//성공
			
			// retern "mvclist"하면 selectall이 안된다.
			
			// list.do 로 redirect 의미:  뷰리졸버가 뷰를 찾지 않고 핸들러매핑으로 간다.
			// 왜냐하면 return시 바로 뷰리졸버로 가는게 아니라 디스패처서블릿이 받고 핸들러매핑으로 보내기때문
			return "redirect:list.do"; 
		}else {
			return "redirect:insertform.do";
		}
		//System.out.println("dto: "+dto.getMyname());
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("dto",biz.selectOne(myno));
		
		return "mvcdetail";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model,int myno) {
		logger.info("UPDATE FORM");
		model.addAttribute("dto",biz.selectOne(myno));
		
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {
		logger.info("UPDATE");
		int res = biz.update(dto);
		
		if(res>0) {return "redirect:detail.do?myno="+dto.getMyno();}
		else {return "redirect:updateform.do?myno="+dto.getMyno();}
		
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		int res = biz.delete(myno);
		
		if(res>0) { return "redirect:list.do";}
		else {return "redirect:list.do";}
	}
	
}
