package com.my.ott.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.my.ott.persistence.AdminDAO;
import com.my.ott.vo.CategoryVO;
import com.my.ott.vo.ContentsVO;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

	@Override
	public void register(ContentsVO vo) throws Exception {
		dao.register(vo);
	}

	@Override
	public List<ContentsViewVO> contentslist() throws Exception {
		return dao.contentslist();
	}

	@Override
	public ContentsViewVO contentsView(int contents_Id) throws Exception {
		return dao.contentsView(contents_Id);
	}

	@Override
	public void contentsModify(ContentsVO vo) throws Exception {
		dao.contentsModify(vo);
	}

	@Override
	public void contentsDelete(int contents_Id) throws Exception {
		dao.contentsDelete(contents_Id);
	}

	@Override
	public List<ReplyListVO> allReply() throws Exception {
		return dao.allReply();
	}

	@Override
	public void deleteReply(int repNum) throws Exception {
		dao.deleteReply(repNum);
	}

}
