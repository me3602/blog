package com.my.blog.infrastructure.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.my.blog.domain.model.entity.Board;

public interface BoardDAO extends JpaRepository<Board, Long> {

	
	Page<Board> findByViewFlag(char viewFlag,Pageable pageable);
	Page<Board> findByViewFlagAndCategory_seqNo(char viewFlag,long seqNo,Pageable pageable);
	

	@Query(value="SELECT b.seqNo, b.title, b.regDate FROM Board b WHERE b.viewFlag='Y' AND b.category.seqNo= :catSeqNo")
	List<Object[]> findBoardSimpleList(@Param("catSeqNo") long catSeqNo);
}
