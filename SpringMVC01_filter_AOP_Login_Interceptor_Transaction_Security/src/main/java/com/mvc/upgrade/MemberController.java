package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		
		return "mvclogin";
	}
	
	//해당 value값을 처리하겠다. method는 어떤 방식으로 보냈는지!
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody // 자바객체를 repose객체에 바인딩
	public Map<String,Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){
		// session객체가 필요하다. 그 session에 로그인 정보를 넣을 테니까.
		logger.info("LOGIN");
		
		// dto안에는 어떤 데이터가 들어가야할까? 입력한 아이디하고 비밀번호가 들어있어야겠죠.
		// 어디서 입력하죠?
		// mvclogin에서 로그인하죠
		// 거기서 입력한 데이터가 여기로 넘어와야하죠
		// 매개변수에 적어서 받았죠.
		// 자바객체로 바꿔준다. 담아준다. 그 데이터 json데이터죠. 그 데이터를 알아서 memberDto에 담아주자.
		// ResponseBody :메소드에 왜? 메서드레벨에 부여된다. 그 친구가 리턴하는 오브젝트는 view를 통해 결과를 만들어 내는 모델로 사용하는 대신에, 응답 메세지 리스펀스 메세지안에 들어있는 ??로 바로 변환된다.
		// 요청한 형태에 맞춰서 메세지 결과값을 반환한다. ajax에 어떤 데이터를 받겟다고되어있었어요? json되어있었죠. 그런식으로 맞춰서 값을 반환을 한다.
		// 제이슨을 자바객체로 자바객체를 제이슨으로 바꾸는걸 jackson이 한다.
		// 내부적으로바껴지는과정 신경 X 알아서 변경
		// 웹페이지에서 제이슨으로 리퀘스트한 파라미터들을
		// 값들을 자바, 우리컨트롤러 자바단이죠 자바에서받으려면 자바오브젝트로 바껴야한다.
		//응답식으로 자바를 제이슨으로 바꿔야겠죠
		// 이러한 작업을 하는 것이 responseBody 아님ㄴ requestBody들이 한다.
		
		/*
		 * 	json으로 request한 parameter들을 java에서 받으려면 java 오브젝트로 변환이 필요
		 * response시 java오브젝트를 json으로 변환이 필요
		 * 이를 처리해주는 어노테이션 @RequestBody @ResponseBody
		 * 
		 * */
		
		// @requestBody:리퀘스트로 들어오는 파라미터들을 자바오브젝트로 바꿔줌
		// @responseBody:리스펀스시에 자바오브젝트를 제이슨으로 변환해서 보내준다.
		
		// RequestBody : 파라미터에
		MemberDto res = biz.login(dto);
		
		boolean check = false;
		
		if(res!=null) {
			// 제대로 로그인 되었다~
			
			// 데이터베이스에 저장되어있는 password와 화면에서 넘어온 password가 일치하는 지 확인.
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				session.setAttribute("login", res);
				check = true;
			}
		}
		
		Map<String ,Boolean> map = new HashMap<String,Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping("/registerform.do")
	public String memberInsertForm() {
		
		return "mvcregister";
	}
	
	@RequestMapping("/register.do")
	public String memberInsert(MemberDto dto) {
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		System.out.println(dto.getMemberpw());
		
		if(biz.insert(dto)>0) {
			return "redirect:loginform.do";
		}
		else {
			return "mvclist";			
		}
	}
	
}
