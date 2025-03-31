package com.my.ott.service;

import java.util.List;

import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;
import com.my.ott.vo.ReplyVO;

public interface OttService {

    public List<ContentsViewVO> list(int cateCode, int level) throws Exception;

	public ContentsViewVO contentsView(int gdsNum) throws Exception;
	
	List<Integer> getLikedContentsNums(String userId) throws Exception;
	
	boolean toggleLike(String userId, int gdsNum) throws Exception;

	public void registReply(ReplyVO reply) throws Exception;
	
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	public void deleteReply(ReplyVO reply) throws Exception;
	
	public String idCheck(int repNum) throws Exception;
	
	public void modifyReply(ReplyVO reply) throws Exception;

}