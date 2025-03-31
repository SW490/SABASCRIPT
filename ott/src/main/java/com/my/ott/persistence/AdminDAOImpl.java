package com.my.ott.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.ott.vo.CategoryVO;
import com.my.ott.vo.ContentsVO;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.my.shop.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	@Override
	public void register(ContentsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	@Override
	public List<ContentsViewVO> contentslist() throws Exception {
		return sql.selectList(namespace + ".contentslist");
	}

	@Override
	public ContentsViewVO contentsView(int contents_Id) throws Exception {
		return sql.selectOne(namespace + ".contentsView", contents_Id);
	}

	@Override
	public void contentsModify(ContentsVO vo) throws Exception {
		sql.update(namespace + ".contentsModify", vo);
	}

	@Override
	public void contentsDelete(int contents_Id) throws Exception {
		sql.delete(namespace + ".contentsDelete", contents_Id);
	}

	@Override
	public List<ReplyListVO> allReply() throws Exception {
		return sql.selectList(namespace + ".allReply");
	}

	@Override
	public void deleteReply(int repNum) throws Exception {
		sql.delete(namespace + ".deleteReply", repNum);
	}

}
