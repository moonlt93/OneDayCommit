package com.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.company.domain.CategoryVO;
@Repository
public interface AdminDAO {

//카테고리 
	
public List<CategoryVO> category() throws Exception;
	
}
