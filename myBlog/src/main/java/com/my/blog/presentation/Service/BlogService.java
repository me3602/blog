package com.my.blog.presentation.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.my.blog.domain.model.entity.Board;
import com.my.blog.domain.model.entity.Category;
import com.my.blog.infrastructure.dao.BoardDao;
import com.my.blog.infrastructure.dao.CategoryDao;
import com.my.blog.util.FileUpload;

@Service("BlogService")
public class BlogService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private FileUpload fileUpload;
	
	public List<Category> getBlogRootCategory(){
		return categoryDao.findRootCategory();
	}
	
	public List<Category> getBlogSubCategory(String root) {
		return categoryDao.findSubCategory(root);		
	}

	public Map<String,Object> setTempFile(MultipartFile file) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//classpath
		Resource resource = new ClassPathResource("/");
		String classPath = "";
		String result = "";
		try {
			classPath = resource.getFile().getPath();
			boolean upResult = fileUpload.registerFileLocal(classPath+"\\resources\\image\\temp\\", file.getContentType(), file.getOriginalFilename(), file.getBytes(), file.getSize());
			result = (upResult)? "SUCC" : "FAIL";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		resultMap.put("result", result);
		if(result.equals("SUCC")) resultMap.put("filename", file.getOriginalFilename());
	
		return resultMap;
	}
	
	public void setBoardArticle(Board board){
		board.setBd_isdel(0);
		board.setBd_hit(0);
		board.setBd_vote(0);
		board.setBd_regdate(new Date());
		board.setBd_moddate(new Date());
		
		boardDao.save(board);
	}

	public List<Board> getArticleLists(String mode) {
		return boardDao.findAll();		
	}
	
}
