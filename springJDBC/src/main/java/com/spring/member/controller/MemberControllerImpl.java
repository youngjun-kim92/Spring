package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName(viewName);  이렇게 두줄로 써줄수도 있다.
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		//getparameter() "" 값은 memberForm.jsp의 name 변수에 담은 이름 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		memberVO.setName(name);
		memberVO.setEmail(email);
		memberService.addMember(memberVO);
		 
		List membersList = memberService.listMembers();
		//실제 넘어가는건 다른거라서? ModelAndView 호출
		ModelAndView mav = new ModelAndView("listMembers");
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		
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