package com.my.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.blog.domain.model.entity.Board;

@Repository("BoardDAO")
public interface BoardDao extends JpaRepository<Board, Long> {
	
	
	
}
