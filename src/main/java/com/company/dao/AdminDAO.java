package com.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
@Repository
public interface AdminDAO {

//카테고리 
	
public List<CategoryVO> category() throws Exception;
	


//상품 등록

public void register(GoodsVO vo) throws Exception;

//상품 리스트

public List<GoodsVO> getList() throws Exception;


//상품조회

public GoodsViewVO goodsView(int gdsNum) throws Exception;


//상품수정

public void goodsModify(GoodsVO vo) throws Exception;

//상품삭제

public void goodsDelete(int gdsNum) throws Exception;

}


