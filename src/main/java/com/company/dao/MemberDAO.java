package com.company.dao;

import org.springframework.stereotype.Repository;

import com.company.domain.MemberVO;

@Repository
public interface MemberDAO {
	
	public void signup(MemberVO vo) throws Exception;

	public MemberVO signin(MemberVO vo) throws Exception;
	

}
