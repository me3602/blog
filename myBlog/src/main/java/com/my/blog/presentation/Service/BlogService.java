package com.my.blog.presentation.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.my.blog.domain.model.entity.Board;
import com.my.blog.domain.model.entity.Category;
import com.my.blog.infrastructure.dao.BoardDAO;
import com.my.blog.infrastructure.dao.CategoryDAO;
import com.my.blog.util.FileUpload;

@Service("BlogService")
public class BlogService {

/*	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BoardDao boardDao;
	
	
	
	public List<Category> getBlogRootCategory(){
		return categoryDao.findRootCategory();
	}
	
	public List<Category> getBlogSubCategory(String root) {
		return categoryDao.findSubCategory(root);		
	}*/
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private FileUpload fileUpload;

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
	
	
	public Page<Board> getIntroBoardList(Pageable pageable){
		return boardDAO.findByViewFlag('Y', pageable);
	}
	
	public Page<Board> getBoardList(String category, Pageable pageable){
		long categorySeqNo = Long.parseLong(category);
		return boardDAO.findByViewFlagAndCategory_seqNo('Y',categorySeqNo, pageable);
	}
	
	public List<Category> getCategory(){		
		return categoryDAO.findByViewFlag('Y', new Sort(Sort.Direction.ASC, "listSeq", "depth"));
	}


	public Board getBoardView(String seqno) {		
		return boardDAO.findOne(Long.parseLong(seqno));
	}
	
		
/*	public void setBoardArticle(Board board){
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
	*/
}
