package com.my.ott.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ott.service.OttService;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.MemberVO;
import com.my.ott.vo.ReplyListVO;
import com.my.ott.vo.ReplyVO;

@Controller
@RequestMapping("/ott/*")
public class OttController {
	
	private static final Logger logger = LoggerFactory.getLogger(OttController.class);
	
	@Inject
	OttService service;
	
	//콘텐츠전체보기리스트
	@GetMapping("/list")
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model, HttpSession session)throws Exception {
		logger.info("소비자 페이지 진입");
		List<ContentsViewVO> list = null;
		list = service.list(cateCode, level);
		model.addAttribute("list",list);
		//유저가 좋아요한 콘텐츠 선별
		MemberVO member = (MemberVO) session.getAttribute("member");
		if (member != null) {
	        List<Integer> likedList = service.getLikedContentsNums(member.getUserId());
	        model.addAttribute("likedList", likedList);
	    }
	}
	
	//콘텐츠상세보기뷰
	@GetMapping("/view")
	public void getView(@RequestParam("n") int contents_Id, Model model, HttpSession session) throws Exception {
		logger.info("get view");
		
		ContentsViewVO view = service.contentsView(contents_Id);
		
		//URL 자동 변환
		String url = view.getContents_video_url();
		if (url != null && url.contains("watch?v=")) {
			
			String videoId = null;
			int start = url.indexOf("watch?v=") + "watch?v=".length();
			int end = url.indexOf("&", start);
			if(end > 0) {
				videoId = url.substring(start, end);
			} else {
				videoId = url.substring(start);
			}
			
			String startTime = "";
			if(url.contains("&t=")) {
				int tIndex = url.indexOf("&t") + 3;
				int ampIndex = url.indexOf("&", tIndex);
				String timeParam = (ampIndex > 0) ? url.substring(tIndex, ampIndex) : url.substring(tIndex);
				startTime = "?start=" + parseTimeInSeconds(timeParam);
			}
			url = "https://www.youtube.com/embed/" + videoId + startTime;
			view.setContents_video_url(url);
		}
		
		model.addAttribute("view",view);
		
		//좋아요 상태 체크
		MemberVO member = (MemberVO) session.getAttribute("member");
		if (member != null) {
	        boolean liked = service.toggleLike(member.getUserId(), contents_Id);
	        model.addAttribute("liked", liked);
	    }
	}
	
	private int parseTimeInSeconds(String time) {
		if (time.endsWith("s")) {
	        return Integer.parseInt(time.replace("s", ""));
	    }
	    if (time.endsWith("m")) {
	        return Integer.parseInt(time.replace("m", "")) * 60;
	    }
	    if (time.endsWith("h")) {
	        return Integer.parseInt(time.replace("h", "")) * 3600;
	    }
	    return 0; //파싱 실패 시 기본 0초
	}

	//좋아요
	@ResponseBody
	@PostMapping("/toggleLike")
	public Map<String, Object> toggleLike(@RequestParam("contents_Id") int contents_Id, HttpSession session) throws Exception {
		Map<String, Object> result = new HashMap<>();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		
		if(member == null) {
			result.put("status","unauthenticated");
			return result;
		}
		boolean liked = service.toggleLike(member.getUserId(), contents_Id);
		result.put("status", "ok");
		result.put("liked", liked);
		return result;
	}
	
	//스크랩
	@GetMapping("/scrap")
	public String getScrap(Model model, HttpSession session) throws Exception {
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    
	    if (member == null) {
	        return "redirect:/member/signin";
	    }

	    List<Integer> likedIds = service.getLikedContentsNums(member.getUserId());
	    List<ContentsViewVO> likedContents = new ArrayList<>();

	    for (int id : likedIds) {
	        ContentsViewVO contents = service.contentsView(id);
	        likedContents.add(contents);
	    }

	    model.addAttribute("list", likedContents);
	    return "ott/scrap";
	}

	
	//댓글쓰기
	@ResponseBody
	@PostMapping(value="/view/registReply")
	public void registReply(ReplyVO reply, HttpSession session)throws Exception{
		logger.info("regist reply");
		MemberVO member = (MemberVO) session.getAttribute("member");
		reply.setUserId(member.getUserId());
		service.registReply(reply);
	}
	
	//댓글리스트
	@ResponseBody
	@GetMapping(value="/view/replyList")
	public List<ReplyListVO> getReplyList(@RequestParam("n") int contents_Id) throws Exception{
		logger.info("리플 리스트 진입");
		List<ReplyListVO> reply = service.replyList(contents_Id);
		return reply;
	}
	
	//댓글삭제 
	@ResponseBody
	@PostMapping(value="/view/deleteReply")
	public int getReplyList(ReplyVO reply, HttpSession session) throws Exception{
		int result = 0; 
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());

		//아이디 비교
		if(member.getUserId().equals(userId)) {
			reply.setUserId(member.getUserId());
			service.deleteReply(reply);
			result = 1;
		}
		return result;
	}
	
	//댓글수정
	@ResponseBody
	@PostMapping(value="/view/modifyReply")
	public int modifyReply(ReplyVO reply, HttpSession session)throws Exception{
		int result = 0;
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
		if(member.getUserId().equals(userId)) {
			reply.setUserId(member.getUserId());
			service.modifyReply(reply);	
			result = 1;
		}
		return result;		
	}
	
}
