package com.company.service;

import java.util.List;

import com.company.domain.CategoryVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	
}
