package com.my.ott.service;

import javax.servlet.http.HttpSession;

import com.my.ott.vo.MemberVO;

public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;

	public MemberVO signin(MemberVO vo) throws Exception;
	
	public void signout(HttpSession session) throws Exception;

}
