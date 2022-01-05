package com.company.service;

import java.util.List;

import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	//상품등록
	public void register(GoodsVO vo)throws Exception;
	
	
	//리스트 조회
	public List<GoodsVO> getList() throws Exception;
	
	//상품조회
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품수정
	
	public void goodsModify(GoodsVO vo) throws Exception;
	
	
	//상품삭제
	
	public void goodsDelete(int gdsNum) throws Exception;
	
	
}
