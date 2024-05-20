package kh.mclass.bbb.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.mclass.bbb.member.model.dto.MemberRes;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberRes> selectList(){
		return sqlSession.selectList("Member.list"); 
	}
	
	public MemberRes selectOne(String memId) {
		return sqlSession.selectOne("Member.one", memId);
	}
	
	public int insert() {
		return 0;
	}
	
	public int update() {
		return 0;
	}
}
