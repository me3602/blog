package com.my.blog.presentation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.my.blog.domain.model.entity.Board;
import com.my.blog.domain.model.entity.Category;
import com.my.blog.presentation.Service.BlogService;

@RestController
@RequestMapping(value="/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "/intro")
	public ModelAndView getBlogIntro(ModelAndView mav){
		//DB에서 블로그 스킨 조회
		String skin = "1st";
		
		//카테고리 조회
		mav.addObject("categoryRoots", blogService.getBlogRootCategory());
		
		//게시글 중 5개 만 출력
		
		
		mav.setViewName("blog/skin/"+ skin +"/intro");
		return mav;
	}
	
	@RequestMapping(value = "/list/{mode}")
	public ModelAndView getBlogList(ModelAndView mav, @PathVariable String mode, Category c){
		//DB에서 블로그 스킨 조회
		String skin = "2nd";
		
		//카테고리 조회
		mav.addObject("categoryRoots", blogService.getBlogRootCategory());
		
		//카테고리 별 리스트 조회
		System.out.println(blogService.getArticleLists(mode).toString());
		
		mav.setViewName("blog/skin/"+ skin +"/list");
		return mav;
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public ModelAndView getBlogWrite(ModelAndView mav){
		//DB에서 블로그 스킨 조회
		String skin = "2nd";
		
		//카테고리 조회
		mav.addObject("categoryRoots",blogService.getBlogRootCategory());		
		
		mav.setViewName("blog/skin/"+ skin + "/write");
		return mav;		
	}
	
	@RequestMapping(value = "/write/{mode}", method=RequestMethod.POST)
	public Board setArticle(ModelAndView mav, 
			@PathVariable String mode, 
			@RequestParam Map<String,Object> params,
			Board board){		
		
		//임시 파일 저장소에서 파일 옮긴 후 패스 저장
		
		//글 저장
		blogService.setBoardArticle(board);		
		
		return board;
	}
	
	@RequestMapping(value = "/upload/{mode}", method=RequestMethod.POST)
	public Map<String,Object> setUpload(ModelAndView mav, 
			@PathVariable String mode, 
			@RequestParam("file") MultipartFile file){		
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		switch(mode){
		case("image"):
			resultMap = blogService.setTempFile(file);
		break;
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "/test" , method = RequestMethod.GET)
	public String test(@RequestParam Map<String,Object> params ){
		
		Resource resource = new ClassPathResource("/");
		try {
			System.out.println(resource.getFile().getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "test";
	}
	
	
	@RequestMapping(value = "/design" , method = RequestMethod.GET)
	public ModelAndView setDesign(ModelAndView mav, @RequestParam Map<String,Object> params ){
		String id = "";
		if(params.containsKey("id")){
			id = "/"+params.get("id").toString();
		}
		
		List<Integer> numList = new ArrayList<Integer>();
		for(int i=0; i <= 20; i++){
			numList.add(i);
		}
		
		
		mav.addObject("listNum", numList);
		
		
		mav.setViewName("blog/design"+id);
		return mav;
	}
	
	/*json*/
	@RequestMapping(value="/json/subMenu/{root}")
	public List<Category> getSubCategory(@PathVariable String root){
		
		return blogService.getBlogSubCategory(root);
		
	}
}
