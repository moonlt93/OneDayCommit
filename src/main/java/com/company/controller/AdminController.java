package com.company.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.domain.CategoryVO;
import com.company.service.AdminService;
import com.company.service.MemberService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService service;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public void getIndex() throws Exception{
		logger.info("get index");
		
		
	}
	
	//상품등록
	@RequestMapping(value="/goods/register",method=RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category=service.category();
		model.addAttribute("category",JSONArray.fromObject(category));
		
	}
	
	
}
