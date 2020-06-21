package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {
	
	@Autowired
	private HelloBiz biz;
	
	//해당 메서드를 매핑을 해준다.
	//컨트롤러 어느 친구가 요청을 처리할 지 매핑을 해준다.
	//만약 hello.do 라고 들어오면 아래의 메소드가 실행이 된다.
	
	//뷰의 요청경로
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// ModelAndView
		// - Controller에서 생성한 데이터를 담아서 View로 전달할 때 사용하는 객체.
		// - Servelt의 request.setAttribute()와 유사한 역할.
		// - addAttribute("키", "값") 메소드를 사용하여 전달할 데이터 세팅.
		
		model.addAttribute("message", biz.getHello());
		return "WEB-INF/views/hello.jsp";
	}
	
	//뷰의 요청 경로
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String nickname) {
		ModelAndView mav = new ModelAndView();
		// Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장.
		
	    // 데이터와 뷰를 동시에 설정이 가능
		mav.setViewName("WEB-INF/views/byejsp.jsp");
		mav.addObject("message","Bye, "+nickname);
		
		return mav;
	}
	
}
