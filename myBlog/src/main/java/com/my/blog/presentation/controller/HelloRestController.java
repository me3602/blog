package com.my.blog.presentation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.blog.domain.model.entity.Board;
import com.my.blog.domain.model.entity.Category;
import com.my.blog.domain.model.entity.Hello;
import com.my.blog.infrastructure.dao.BoardDao;
import com.my.blog.infrastructure.dao.CategoryDao;
import com.my.blog.infrastructure.dao.HelloDao;

@RestController
public class HelloRestController {
	@Autowired
	private HelloDao helloDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
/*	@Autowired
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;*/
	
	@RequestMapping("/listTest")
	public List getList(){
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("name", "cheon");
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("name", "young");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		
		return list;
	}
	
/*	@RequestMapping("/test/board")
	public List<Board> setBoardData(Board board){
		Category category = new Category();
		category.setCat_name("카테고리1");		
		categoryDao.save(category);		
		
		board.setCategory(category);		
		Category category = categoryDao.getOne(board.getCat_idx());
		board.setCategory(category);
		Board boardData = boardDao.save(board);
		
		
		List<Board> list = boardDao.findAll();
		List<Board> returnList = new ArrayList<Board>();
		if(list == null){
			System.out.println("널");
		}else{
			for(Board b : list){
				System.out.println(b.toString());
				System.out.println(b.getCategory().toString());
			}
		}
		
		
		return returnList;
	}*/
	
	@RequestMapping("/test/view")
	public Board testView(Model model){
		

		Board list = boardDao.findOne((long) 1);
		
	/*	if(list == null){
			Board b = new Board();
			b.setBd_title("없음");
			
			list.add(b);
		}*/
		
		
		return list;
	}
	
	@RequestMapping("/test/cat")
	public Category setCategory(Category category){
		
		Category catData = categoryDao.save(category);
		
		return catData;
	}
	@RequestMapping("/test/cat/all")
	public List<Category> getCategory(){		
		return categoryDao.findAll();
	}
	
	@RequestMapping("/add")
	public Hello Add(Hello hello){
		
		Hello helloData = helloDao.save(hello);
		
		return helloData;
	}
	
	@RequestMapping("/list")
	public List<Hello> list(Model model){
		List<Hello> list = helloDao.findAll();
		
		return list;
	}
	
	@RequestMapping(value="/intro")
	public ModelAndView viewTest(ModelAndView mv, Map<String,Object> modelMap){
		modelMap.put("intro", "Hellow View Page!");
		mv.setViewName("intro/intro");
		
		return mv;		
	}
	
	@RequestMapping("/")
	public String Hello(){
		return "Hello Wolrd!";
	}
}
