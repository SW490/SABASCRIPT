package com.my.ott.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.my.ott.service.AdminService;
import com.my.ott.utils.UploadFileUtils;
import com.my.ott.vo.CategoryVO;
import com.my.ott.vo.ContentsVO;
import com.my.ott.vo.ContentsViewVO;
import com.my.ott.vo.ReplyListVO;
import com.my.ott.vo.ReplyVO;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@GetMapping("/index")
	public void getIndex() throws Exception {
		logger.info("관리자 화면 진입");
	}
	
	@GetMapping("/contents/register")
	public void getContentsRegister(Model model) throws Exception {
		logger.info("상품등록 페이지 진입");
		
		List<CategoryVO> category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	@PostMapping("/contents/register")
	public String postContentsRegister(ContentsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		String uploadPath = req.getSession().getServletContext().getRealPath("/resources/imgUpload");
		String ymdPath = UploadFileUtils.calcPath(uploadPath);
		String fileName = UploadFileUtils.fileUpload(uploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtils.fileUpload(uploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			vo.setContents_poster_img("/resources/imgUpload" + ymdPath + "/" + fileName);
			vo.setContents_thumb_img("/resources/imgUpload" + ymdPath + "/s/s_" + fileName);
		}else {
			fileName = File.separator + "images" + File.separator + "none.png";
			vo.setContents_poster_img(fileName);
			vo.setContents_thumb_img(fileName);
		}
		adminService.register(vo);
		return "redirect:/admin/index";
	}
	
	@GetMapping(value="/contents/list")
	public void getContentsList(Model model) throws Exception {
		logger.info("상품 리스트 출력");
		List<ContentsViewVO>list = adminService.contentslist();
		model.addAttribute("list", list);
	}
	
	@GetMapping(value="/contents/view")
	public void getContentsview(@RequestParam("n") int contents_Id, Model model) throws Exception {
		logger.info("상세페이지");
		ContentsViewVO contents = adminService.contentsView(contents_Id);
		model.addAttribute("contents", contents);
	}
	
	@PostMapping(value="/contents/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		logger.info("ck에디터에 첨부파일 등록");
		UUID uid = UUID.randomUUID();
		OutputStream out = null;
		PrintWriter printWriter = null;
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html, charset=utf-8");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			//ckuploadpath
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush(); //out에 저장된 데이터 전송 후 초기화
			
			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "/ckUpload" + uid + "_" + fileName; //작성화면
			
			//메세지 출력
			printWriter.println("<script>"
					+ "window.parent.CKEDITOR.tools.callFunction("
					+ callback +", '"+ fileUrl +"', '이미지를 업로드하였습니다.')"
					+ "</script>");
			printWriter.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {out.close();}
				if(printWriter != null) {printWriter.close();}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
	//상품수정
	@GetMapping(value="/contents/modify")
	public void getContentsModify(@RequestParam("n") int contents_Id, Model model) throws Exception{
		logger.info("수정 페이지 진입");
		ContentsViewVO contents = adminService.contentsView(contents_Id);
		model.addAttribute("contents",contents);
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	@PostMapping(value="/contents/modify")
	public String postContentsModify(ContentsVO vo, MultipartFile file, HttpServletRequest req) throws Exception{
		logger.info("상품 수정");
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(uploadPath + req.getParameter("contents_poster_img")).delete();
			new File(uploadPath + req.getParameter("contents_thumb_img")).delete();
			
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			vo.setContents_poster_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setContents_thumb_img(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		}else {
			vo.setContents_poster_img(req.getParameter("contents_poster_img"));
			vo.setContents_thumb_img(req.getParameter("contents_thumb_img"));
		}
		adminService.contentsModify(vo);
		return "redirect:/admin/index";
	}
	
	//상품삭제
	@PostMapping(value="/contents/delete")
	public String postContentsDelete(@RequestParam("n") int contents_Id) throws Exception {
		logger.info("상품 삭제");
		adminService.contentsDelete(contents_Id);
		return "redirect:/admin/index";
	}
	
	//댓글
	@GetMapping(value="ott/allReply")
	public void getAllReply(Model model) throws Exception {
		logger.info("소비자가 쓴 모든 댓글");
		List<ReplyListVO> reply = adminService.allReply();
		model.addAttribute("reply",reply);
	}
	
	@PostMapping(value="ott/allReply")
	public String postAllReply(ReplyVO reply) throws Exception {
		logger.info("소비자가 쓴 모든 댓글 삭제");
		adminService.deleteReply(reply.getRepNum());
		return "redirect:/admin/ott/allReply";
	}
}
