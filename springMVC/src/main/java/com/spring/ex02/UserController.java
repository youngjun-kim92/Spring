package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		// 보여줄 jsp 이름 정의
		//요청받은 매핑이름을 viewName변수에 넣음
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//setAttribute 역할을 addObject가 함
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		
		//ModelAndView 객체에 포워딩할 jsp이름을 설정
//		mav.setViewName("login");
		mav.setViewName(viewName);
		
		return mav;			
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		
//		mav.setViewName("memberInfo");
		mav.setViewName(viewName);
		
		return mav;
	}	
	
	//요청명과 동일한 jsp 표시하기(포워딩)
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		// uri가 uri변수에 들어감
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		// uri가 null일 때
		if(uri == null || uri.trim().equals("")) {
			//uri에 값 넣어주기
			uri = request.getRequestURI();
		}
		int begin = 0, end;
		if(!((contextPath == null) || "".equals(contextPath))) {
			//contextPath의 길이를 begin에 넣음
			begin = contextPath.length();
		}
		if(uri.indexOf(";") != -1) {
			//주소에 ;가 있다면 ;발견한 위치를 end값으로 하겠다
			end = uri.indexOf(";");			
		} else if(uri.indexOf("?") != -1) {
			//주소에 ?가 있다면 ?발견한 위치를 end값으로 하겠다
			end = uri.indexOf("?");		
		} else {
			//아무 특수문자 없이 왔다면 uri길이를 end 값으로 쓰겠다
			end = uri.length();
		}
		String fileName = uri.substring(begin, end);
		if(fileName.lastIndexOf(".") != -1) {
			//.이 있다
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}
}
