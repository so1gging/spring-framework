package com.mvc.upgrade.biz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NameController {
	@RequestMapping("/viewname.do")
	public String test() {
		return "/test/test";
	}
}
