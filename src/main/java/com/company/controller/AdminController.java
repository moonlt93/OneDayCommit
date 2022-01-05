package com.company.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
import com.company.service.AdminService;
import com.company.service.MemberService;
import com.company.util.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
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
	
	@RequestMapping(value="/goods/register",method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo , MultipartFile file) throws Exception{
		
		String imgUploadPath =uploadPath+File.separator + "image";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName= null;
		
		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
		} else {
			fileName = uploadPath + File.separator+"images"+File.separator + "name.png";
		}
		
		vo.setGdsImg(File.separator+"imgUpload"+ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator+"s"+File.separator + "s_" + fileName);
		

		service.register(vo);
		
		
		return "redirect:/admin/index";
	}
	
	
	@RequestMapping(value ="/goods/list", method=RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception{
		
		logger.info("get list 페이지");
		
		List<GoodsVO> list = service.getList();
		
		model.addAttribute("list",list);
	}
	
	
	@RequestMapping(value="/goods/view",method=RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get goods view");
		
		GoodsViewVO goods = service.goodsView(gdsNum);
		
		model.addAttribute("goods",goods);
	}
	
	
	@RequestMapping(value="/goods/modify" , method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum,Model model) throws Exception{
		
		logger.info("상품수정페이지");
		
		GoodsViewVO goods = service.goodsView(gdsNum);
		model.addAttribute("goods",goods);
		
		List<CategoryVO> category = null;
		category = service.category();
		System.out.println("category리스트"+category);
		model.addAttribute("category", JSONArray.fromObject(category));
		
		
	}
	
	
	
	// 상품 수정
	@RequestMapping(value ="/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo) throws Exception {
	 logger.info("post goods modify");

	 service.goodsModify(vo);
	 
	 return "redirect:/admin/index";
	}
	
	
	// 상품 삭제
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
	 logger.info("post goods delete");

	 service.goodsDelete(gdsNum);
	 
	 return "redirect:/admin/index";
	}
	
}
