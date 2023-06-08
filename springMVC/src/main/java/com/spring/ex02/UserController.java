package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class UserController extends MultiActionController {
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName=getViewName(request);
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		mav.addObject("id",id);
		mav.addObject("pwd",pwd);
		mav.setViewName(viewName); 						//ModelAndView 객체에 포워딩할 jsp 이름을 설정
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName=getViewName(request);
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		mav.addObject("id",id);
		mav.addObject("pwd",pwd);
		mav.addObject("name",name);
		mav.addObject("email",email);
		mav.setViewName(viewName);
		return mav;
	}
	
	//요청명과 동일한 jsp 표시하기
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath=request.getContextPath();
		String uri=(String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null||uri.trim().equals("")) {
			uri=request.getRequestURI();
		}
		int begin=0, end;
		if(!((contextPath==null)||"".equals(contextPath))) {
			begin=contextPath.length();
		}
		if(uri.indexOf(";")!=-1) {
			end=uri.indexOf(";");
		}
		else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
		}
		else {
			end=uri.length();
		}
		String fileName=uri.substring(begin,end);
		if(fileName.lastIndexOf(".")!=-1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/")!=-1) {
			fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		}
		return fileName;
	}
}
