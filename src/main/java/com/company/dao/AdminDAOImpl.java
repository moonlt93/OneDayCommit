package com.company.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.domain.CategoryVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace ="com.company.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		
		return sql.selectList(namespace+".category");
	}
	
	
}
