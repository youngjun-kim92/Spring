package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List selectAllMembers() throws DataAccessException {
		List membersList = new ArrayList();
		String query = "select * from membertbl order by joinDate desc";
		membersList = this.jdbcTemplate.query(query, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				return memberVO;
			}			
		});
		return membersList;
	}
	@Override
	public void addMember(MemberVO memberVO) throws DataAccessException {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		//String query = "insert into membertbl(id, pwd, name, email) values('hong', '1234', '홍길동', 'hong@naver.com')";
		String query = "insert into membertbl(id, pwd, name, email) "
			+ "values('" + id + "', '" + pwd + "', '" + name + "', '" + email+"')";
		//jdbcTemplate : 스프링에서 DB 처리하는 클래스
		jdbcTemplate.update(query);
	}
}