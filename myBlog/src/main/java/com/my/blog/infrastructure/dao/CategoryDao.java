package com.my.blog.infrastructure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.my.blog.domain.model.entity.Category;

@Repository("CategoryDAO")
public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	@Query(value="SELECT * FROM category WHERE sub_cat_name='root'", nativeQuery=true)
	List<Category> findRootCategory(); 
	
	@Query(value="SELECT * FROM category WHERE cat_name=?#{[0]} AND sub_cat_name !='root'", nativeQuery=true)
	List<Category> findSubCategory(String root); 
	

}
