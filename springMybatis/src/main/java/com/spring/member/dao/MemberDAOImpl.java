package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberVO> selectAllMembers() throws DataAccessException {
		List<MemberVO> membersList=null;
		membersList=sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public void addMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.insert("mapper.member.insertMember",memberVO);
		
	}

	@Override
	public MemberVO findMember(String id) throws DataAccessException {
		MemberVO memberVO=(MemberVO)sqlSession.selectOne("mapper.member.findMember",id);
		return memberVO;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.update("mapper.member.updateMember",memberVO);
		
	}

	@Override
	public void delMember(String id) throws DataAccessException {
		sqlSession.delete("mapper.member.delMember",id);
	}
	
	
	
	

}
