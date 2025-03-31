package com.my.ott.persistence;

import com.my.ott.vo.MemberVO;

public interface MemberDAO {

	public void signup(MemberVO vo) throws Exception;
	
	public MemberVO signin(MemberVO vo) throws Exception;
}
