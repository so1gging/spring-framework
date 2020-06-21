package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//Controller 실행 요청 전에 수행되는 메소드.
	//return 값이 false인 경우 controller 실행 시키지 않는다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[interceptor] : preHandle ");
		
		if(request.getRequestURI().contains("/loginform.do") 
				|| request.getRequestURI().contains("/ajaxlogin.do")
				|| request.getSession().getAttribute("login")!=null) {
			//세 개의 요청이 들어오게 된다면,
			// 요청이 loginform이거나, ajaxlogin.do 거나, login이 null이 아닐 때.
			return true; //controller실행
		}
		if(request.getSession().getAttribute("login")==null) {
			//null일때 아무것도 안들어있을 때.
			
			response.sendRedirect("loginform.do");
			// 컨트롤러에서 요청할 때 redirect:list.do ==> dispatcher가 view가 아닌 핸들러매핑으로 보낸다.
			// 
			return false;
		}
		
		
		return false;
	}

	// View단으로 forward 되기 전에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[interceptor] : postHandle");
		
	}

	//view까지 처리가 끝난 후 처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("[interceptor] : afterCompletion");
	}

}
