package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//매핑된 요청에 대해 controller 기능을 수행
public class TestUrlController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//ModelAndView 하는 일 : 컨트롤러가 처리한 결과 및 뷰 선택에 필요한 정보를 저장 - jsp로 포워딩해줌
		ModelAndView mav = new ModelAndView("index.jsp");
		return mav;
	}	
}