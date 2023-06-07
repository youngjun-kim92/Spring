package com.spring.member;

public class MemberServiceImpl implements MemberService{
	
	//주입되는 bean을 저장할 MemberDAO타입의 속성을 선언
	private MemberDAO memberDAO;
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}



	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
	
}
