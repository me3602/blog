package com.my.blog.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="category",uniqueConstraints={@UniqueConstraint(columnNames={"cat_name","sub_cat_name"})})
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cat_id;
	
	private String cat_name;
	
	private String sub_cat_name;
	
	private Integer cat_view_auth;
	
	public Category(){};
	
	public Category(String cat_name) {
		this.cat_name = cat_name;
	}	
	
	
	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getSub_cat_name() {
		return sub_cat_name;
	}

	public void setSub_cat_name(String sub_cat_name) {
		this.sub_cat_name = sub_cat_name;
	}
	public Integer getCat_view_auth() {
		return cat_view_auth;
	}
	public void setCat_view_auth(Integer cat_view_auth) {
		this.cat_view_auth = cat_view_auth;
	}


	@Override
	public String toString() {
		return "Category [cat_name=" + cat_name + ", cat_view_auth=" + cat_view_auth + "]";
	}

}


