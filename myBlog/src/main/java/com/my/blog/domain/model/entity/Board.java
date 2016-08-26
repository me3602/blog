package com.my.blog.domain.model.entity;





import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="board" )
public class Board {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bd_idx;
	

	@ManyToOne( fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="cat_idx")})
	private Category category;
	
	private String bd_writer;
	
	private String bd_title;
	private String bd_contents;	
	private Integer bd_hit;
	private Integer bd_vote;
	private int bd_isdel;
	private String bd_filepath;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date bd_regdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date bd_moddate;
	
	public Long getBd_idx() {
		return bd_idx;
	}
	public void setBd_idx(Long bd_idx) {
		this.bd_idx = bd_idx;
	}
	public String getBd_writer() {
		return bd_writer;
	}
	public void setBd_writer(String bd_writer) {
		this.bd_writer = bd_writer;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getBd_contents() {
		return bd_contents;
	}
	public void setBd_contents(String bd_contents) {
		this.bd_contents = bd_contents;
	}
	public Date getBd_regdate() {
		return bd_regdate;
	}
	public void setBd_regdate(Date bd_regdate) {
		this.bd_regdate = bd_regdate;
	}
	public Date getBd_moddate() {
		return bd_moddate;
	}
	public void setBd_moddate(Date bd_moddate) {
		this.bd_moddate = bd_moddate;
	}
	public Integer getBd_vote() {
		return bd_vote;
	}
	public void setBd_vote(Integer bd_vote) {
		this.bd_vote = bd_vote;
	}
	public int getBd_isdel() {
		return bd_isdel;
	}
	public void setBd_isdel(int bd_isdel) {
		this.bd_isdel = bd_isdel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getBd_hit() {
		return bd_hit;
	}
	public void setBd_hit(Integer bd_hit) {
		this.bd_hit = bd_hit;
	}
	public String getBd_filepath() {
		return bd_filepath;
	}
	public void setBd_filepath(String bd_filepath) {
		this.bd_filepath = bd_filepath;
	}
	@Override
	public String toString() {
		return "Board [bd_idx=" + bd_idx + ", bd_writer=" + bd_writer + ", bd_title="
				+ bd_title + ", bd_contents=" + bd_contents + ", bd_regdate=" + bd_regdate + ", bd_moddate="
				+ bd_moddate + ", bd_vote=" + bd_vote + ", bd_isdel=" + bd_isdel + "]";
	}
	
	
}
