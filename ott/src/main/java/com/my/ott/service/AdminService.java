package com.my.ott.service;

import java.util.List;

import com.my.ott.vo.CategoryVO;
import com.my.ott.vo.ContentsVO;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;

public interface AdminService {

	public List<CategoryVO> category() throws Exception;//category
	
	public void register(ContentsVO vo) throws Exception;//register

	public List<ContentsViewVO> contentslist() throws Exception;//list
	
	public ContentsViewVO contentsView(int contents_Id) throws Exception;//view
	
	public void contentsModify(ContentsVO vo) throws Exception;//update
	
	public void contentsDelete(int contents_Id) throws Exception;//delete
	
	public List<ReplyListVO> allReply() throws Exception;
	
	public void deleteReply(int repNum) throws Exception; 
}
