package com.company.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace ="com.company.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		
		return sql.selectList(namespace+".category");
	}
	
	
	@Override
	public void register(GoodsVO vo) throws Exception {
	
		 sql.insert(namespace+".register",vo);
	}
	
	
	@Override
	public List<GoodsVO> getList() throws Exception {
		
		return sql.selectList(namespace+".getList");
	}
	
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception{
		return sql.selectOne(namespace +".goodsView",gdsNum);
	}
	
	
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		
		sql.update(namespace + ".goodsModify",vo);
		
	}
	
	
	
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		
		sql.delete(namespace+".goodsDelete",gdsNum);
		
	}
	
}
