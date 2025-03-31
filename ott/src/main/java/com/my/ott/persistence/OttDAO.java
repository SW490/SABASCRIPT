package com.my.ott.persistence;

import java.util.List;

import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;
import com.my.ott.vo.ReplyVO;

public interface OttDAO {

	//상품리스트
	public List<ContentsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	List<ContentsViewVO> list(int cateCode) throws Exception;

	//상품조회
	public ContentsViewVO contentsView(int contents_Id) throws Exception;
	
	//좋아요
	int checkLike(String userId, int contents_Id) throws Exception;
	
	//좋아요추가
	public void insertLike(String userId, int contents_Id) throws Exception;
	
	//좋아요삭제
	public void deleteLike(String userId, int contents_Id) throws Exception;
	
	//좋아요증가
	public void incrementLikes(int contents_Id) throws Exception;
	
	//좋아요감소
	public void decrementLikes(int contents_Id) throws Exception;  
	
	//좋아요한 콘텐츠
	List<Integer> getLikedContentsNums(String userId) throws Exception;
	
	//댓글쓰기
	public void registReply(ReplyVO reply) throws Exception;
	
	//댓글리스트
	public List<ReplyListVO> replyList(int contents_Id) throws Exception;
	
	//댓글삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//아이디체크
	public String idCheck(int repNum) throws Exception;
	
	//댓글수정
	public void modifyReply(ReplyVO reply) throws Exception;

}
