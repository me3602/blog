package com.my.blog.infrastructure.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.my.blog.domain.model.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {
	
	List<Category> findByViewFlag(char viewFlag,Sort sort);
	Category findBySeqNo(Long seqNo);
}
