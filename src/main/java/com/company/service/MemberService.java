package com.company.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.company.domain.MemberVO;

@Service
public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;

	public MemberVO signin(MemberVO vo) throws Exception;
	
	public void signout(HttpSession session) throws Exception;
}
