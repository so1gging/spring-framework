package com.mvc.upgrade;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	@RequestMapping("/test.do")
	public String test() {
		return "/test/test";
	}
	
	@RequestMapping("/parameter.do")
	public String testParameter(@RequestParam("no") int parameter, @RequestParam("string") String parameter2) {
		logger.info("parameter : "+parameter);
		logger.info("parameter2 : "+parameter2);
		
		return "/test/test";
	}
	
	@RequestMapping("/required.do")
	public String testRequired(@RequestParam(value="no",required=false) Integer parameter, @RequestParam("string") String parameter2) {
		logger.info("parameter : "+parameter);
		logger.info("parameter2 : "+parameter2);
		
		return "/test/test";
	}
	
	@RequestMapping("/paramMap.do")
	public String testMap(@RequestParam Map<String,String> info) {
		logger.info("id : " + info.get("id"));
		logger.info("password : " + info.get("password"));
		
		return "/test/test";
	}	
	
	@RequestMapping("/members/{memberId}/pathVariable.do")
	public String memberDetail(@PathVariable("memberId") String memberId, Model model){
		logger.info("memberId : " + memberId);
		return "/test/test";
	}
	
	@RequestMapping("/modeltest.do")
	public String modelTest(Model model, @RequestParam("test") String test) {
		model.addAttribute("test", test);
		return "/test/model";
	}

	
}
