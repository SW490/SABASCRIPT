package com.my.ott.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.my.ott.persistence.OttDAO;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;
import com.my.ott.vo.ReplyVO;

@Service
public class OttServiceImpl implements OttService {

	@Inject
	private OttDAO dao;
	
	@Override
	public List<ContentsViewVO> list(int cateCode, int level) throws Exception {
		int cateCodeRef = 0;
		if(level == 1) {
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		}else {
			return dao.list(cateCode);
		}
	}
	
	@Override
	public ContentsViewVO contentsView(int gdsNum) throws Exception {
		return dao.contentsView(gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return dao.replyList(gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		dao.deleteReply(reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		return dao.idCheck(repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		dao.modifyReply(reply);
	}

	@Override
	public List<Integer> getLikedContentsNums(String userId) throws Exception {
		return dao.getLikedContentsNums(userId);
	}
	
	@Override
	public boolean toggleLike(String userId, int gdsNum) throws Exception {
		int check = dao.checkLike(userId, gdsNum);
		if(check == 0) {
			dao.insertLike(userId, gdsNum);
			dao.incrementLikes(gdsNum);
			return true;
		}else {
			dao.deleteLike(userId, gdsNum);
			dao.decrementLikes(gdsNum);
			return false;
		}
	}

}
