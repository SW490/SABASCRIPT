package com.my.shop.persistence;

import java.util.List;

import com.my.shop.vo.CategoryVO;
import com.my.shop.vo.GoodsVO;
import com.my.shop.vo.GoodsViewVO;

public interface AdminDAO {

	public List<CategoryVO> category() throws Exception;//category

	public void register(GoodsVO vo) throws Exception;//goods register
	
	public List<GoodsViewVO> goodslist() throws Exception;//goods list
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;//goods view

	public void goodsModify(GoodsVO vo) throws Exception;//goods up date
	
	public void goodsDelete(int gdsNum) throws Exception;//goods delete
}
