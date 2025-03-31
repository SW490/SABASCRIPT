package com.my.ott.persistence;

import java.util.List;

import com.my.ott.vo.CategoryVO;
import com.my.ott.vo.ContentsVO;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;

public interface AdminDAO {

	public List<CategoryVO> category() throws Exception;

	public void register(ContentsVO vo) throws Exception;
	
	public List<ContentsViewVO> contentslist() throws Exception;
	
	public ContentsViewVO contentsView(int contents_Id) throws Exception;

	public void contentsModify(ContentsVO vo) throws Exception;
	
	public void contentsDelete(int contents_Id) throws Exception;
	
	public List<ReplyListVO> allReply() throws Exception;
	
	public void deleteReply(int repNum) throws Exception; 
	
}
