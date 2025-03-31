package com.my.ott.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;
import com.my.ott.vo.ReplyVO;

@Repository
public class OttDAOImpl implements OttDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.my.ott.mappers.ottMapper";

	//상품리스트1
	@Override
	public List<ContentsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace + ".list_1", map);
	}

	//상품리스트2
	@Override
	public List<ContentsViewVO> list(int cateCode) throws Exception {
		return sql.selectList(namespace + ".list_2", cateCode);
	}
	
	//상품조회
	@Override
	public ContentsViewVO contentsView(int contents_Id) throws Exception {
		return sql.selectOne("com.my.ott.mappers.adminMapper"+".goodsView",contents_Id);
	}

	//댓글쓰기
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}

	//댓글리스트
	@Override
	public List<ReplyListVO> replyList(int contents_Id) throws Exception {
		return sql.selectList(namespace + ".replyList", contents_Id);
	}
	
	//댓글삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}

	//아이디체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	//댓글수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}

	//좋아요
	@Override
	public int checkLike(String userId, int contents_Id) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("contents_Id", contents_Id);
		return sql.selectOne(namespace + ".checkLike", map);
	}

	//좋아요쓰기
	@Override
	public void insertLike(String userId, int contents_Id) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("contents_Id", contents_Id);
		sql.insert(namespace + ".insertLike", map);
	}

	//좋아요삭제
	@Override
	public void deleteLike(String userId, int contents_Id) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("contents_Id", contents_Id);
		sql.delete(namespace + ".deleteLike", map);
	}

	//좋아요증가
	@Override
	public void incrementLikes(int contents_Id) throws Exception {
		sql.update(namespace + ".incrementLikes", contents_Id);
	}

	//좋아요감소
	@Override
	public void decrementLikes(int contents_Id) throws Exception {
		sql.update(namespace + ".decrementLikes", contents_Id);
	}

	//좋아요한 콘텐츠
	@Override
	public List<Integer> getLikedContentsNums(String userId) throws Exception {
		return sql.selectList(namespace + ".getLikedGoodsNums", userId);
	}
	
}
