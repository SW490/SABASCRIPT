package com.my.shop.service;

import java.util.List;

import com.my.shop.vo.CategoryVO;
import com.my.shop.vo.GoodsVO;
import com.my.shop.vo.GoodsViewVO;

public interface AdminService {

	public List<CategoryVO> category() throws Exception;//category
	
	public void register(GoodsVO vo) throws Exception;//register

	public List<GoodsViewVO> goodslist() throws Exception;//list
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;//view
	
	public void goodsModify(GoodsVO vo) throws Exception;//update
	
	public void goodsDelete(int gdsNum) throws Exception;//delete
	
}
