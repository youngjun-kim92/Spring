package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")
@RequestMapping("/test")
public class MainController {
	
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
	public ModelAndView mainMethod1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","오늘은 수요일");
		mav.setViewName("main");
		return mav;
	}
}
