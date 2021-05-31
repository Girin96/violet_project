package com.bteam.violet.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//import com.bteam.violet.domain.Criteria;
import com.bteam.violet.domain.CustVO;
import com.bteam.violet.domain.SearchCriteria;

@Repository
public class CustDAOImpl implements CustDAO{
	
	@Inject SqlSession sql;
	
	//회원가입
	@Override
	public void register(CustVO custVO) throws Exception {
		sql.insert("CustMapper.register", custVO);	 		
	}
	
	// 로그인
	@Override
	public CustVO login(CustVO custVO) throws Exception {
		return sql.selectOne("CustMapper.login", custVO);
	}

	// 전체회원 정보 조회
	@Override
	public List<CustVO> custList(SearchCriteria scri) throws Exception{
		return sql.selectList("CustMapper.info", scri);
	}
	
	// 회원정보 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return sql.selectOne("CustMapper.listCount", scri);
	}
		
	//회원 존재 여부
	@Override
	public boolean isCust(String cust_id) {
		return (int)sql.selectOne("CustMapper.isCust", cust_id) == 1 ? true : false;
	}

	
	// 회원 탈퇴
	@Override
	public void deletecust(String cust_id) {
		sql.delete("CustMapper.deletecust", cust_id);
		
	}

	

	
	

}