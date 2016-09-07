package com.my.blog.domain.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author paxnet
 *
 */
@Entity
@Table(name="BOARD")
public class Board {

	@Id @GeneratedValue
	@Column(name="BD_SEQ_NO")
	private long seqNo;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="USER_NICK")
	private String userNick;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENTS", columnDefinition="mediumtext")
	private String contents;
	
	@Column(name="HIT")
	private int hit;
	
	@Column(name="REG_DATE",  columnDefinition="datetime")
	private Date regDate;
	
	@Column(name="MOD_DATE",  columnDefinition="datetime")
	private Date modDate;
	
	@Column(name="NOTICE_FLAG")
	private char noticeFlag;
	
	@Column(name="VIEW_FLAG")
	private char viewFlag;
	
	@ManyToOne
	@JoinColumn(name="CAT_SEQ_NO")
	private Category category;

	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public char getNoticeFlag() {
		return noticeFlag;
	}

	public void setNoticeFlag(char noticeFlag) {
		this.noticeFlag = noticeFlag;
	}
	
	public char getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(char viewFlag) {
		this.viewFlag = viewFlag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Board [seqNo=" + seqNo + ", userId=" + userId + ", userNick=" + userNick + ", title=" + title
				+ ", contents=" + contents + ", hit=" + hit + ", regDate=" + regDate.toString() + ", modDate=" + modDate.toString()
				+ ", noticeFlag=" + noticeFlag + ", viewFlag=" + viewFlag 
				+ ", category=" + category.toString() + "]";
	}
	
	
	
}
