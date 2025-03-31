package com.my.ott.vo;

import java.util.Date;

public class ContentsViewVO {

	private int contents_Id;
	private String contents_title;
	private String contents_cateCode;
	private String contents_description;
	private String contents_poster_img;
	private String contents_thumb_img;
	private Date contents_created_at;
	private int contents_likes;
	private int contents_reviewCounts;
	private String contents_video_url;
	
	public int getContents_Id() {
		return contents_Id;
	}
	public void setContents_Id(int contents_Id) {
		this.contents_Id = contents_Id;
	}
	public String getContents_title() {
		return contents_title;
	}
	public void setContents_title(String contents_title) {
		this.contents_title = contents_title;
	}
	public String getContents_cateCode() {
		return contents_cateCode;
	}
	public void setContents_cateCode(String contents_cateCode) {
		this.contents_cateCode = contents_cateCode;
	}
	public String getContents_description() {
		return contents_description;
	}
	public void setContents_description(String contents_description) {
		this.contents_description = contents_description;
	}
	public String getContents_poster_img() {
		return contents_poster_img;
	}
	public void setContents_poster_img(String contents_poster_img) {
		this.contents_poster_img = contents_poster_img;
	}
	public String getContents_thumb_img() {
		return contents_thumb_img;
	}
	public void setContents_thumb_img(String contents_thumb_img) {
		this.contents_thumb_img = contents_thumb_img;
	}
	public Date getContents_created_at() {
		return contents_created_at;
	}
	public void setContents_created_at(Date contents_created_at) {
		this.contents_created_at = contents_created_at;
	}
	public int getContents_likes() {
		return contents_likes;
	}
	public void setContents_likes(int contents_likes) {
		this.contents_likes = contents_likes;
	}
	public int getContents_reviewCounts() {
		return contents_reviewCounts;
	}
	public void setContents_reviewCounts(int contents_reviewCounts) {
		this.contents_reviewCounts = contents_reviewCounts;
	}
	public String getContents_video_url() {
		return contents_video_url;
	}
	public void setContents_video_url(String contents_video_url) {
		this.contents_video_url = contents_video_url;
	}
	
	
	
}