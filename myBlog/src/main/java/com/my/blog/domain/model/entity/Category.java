package com.my.blog.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CATEGORY",uniqueConstraints={
		@UniqueConstraint(columnNames={"NAME","PARENT_SEQ"})
		})
public class Category {

	@Id @GeneratedValue
	@Column(name="CAT_SEQ_NO")
	private long seqNo;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PARENT_SEQ")
	private long parentSeq; 
	
	@Column(name="PARENT_NAME")
	private String parentName; 
	
	@Column(name="DEPTH")
	private int depth;
	
	@Column(name="LIST_SEQ")
	private int listSeq;	

	@Column(name="VIEW_FLAG")
	private char viewFlag;

	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParentSeq() {
		return parentSeq;
	}

	public void setParentSeq(long parentSeq) {
		this.parentSeq = parentSeq;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getListSeq() {
		return listSeq;
	}

	public void setListSeq(int listSeq) {
		this.listSeq = listSeq;
	}

	public char getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(char viewFlag) {
		this.viewFlag = viewFlag;
	}

	@Override
	public String toString() {
		return "Category [seqNo=" + seqNo + ", name=" + name + ", parentSeq=" + parentSeq + ", parentName=" + parentName
				+ ", depth=" + depth + ", listSeq=" + listSeq + ", viewFlag=" + viewFlag + "]";
	}

	
		
	
}
