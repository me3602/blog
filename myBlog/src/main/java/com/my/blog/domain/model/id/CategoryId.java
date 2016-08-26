package com.my.blog.domain.model.id;

import java.io.Serializable;

public class CategoryId implements Serializable {
	private int cat_id;
	private String cat_name;
	private String sub_cat_name;
	
	public CategoryId(){}
	
	
	public CategoryId(int cat_id, String cat_name, String sub_cat_name) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.sub_cat_name = sub_cat_name;
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cat_id;
		result = prime * result + ((cat_name == null) ? 0 : cat_name.hashCode());
		result = prime * result + ((sub_cat_name == null) ? 0 : sub_cat_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof CategoryId) 
				&& cat_id == ((CategoryId)obj).getCat_id()
				&& cat_name == ((CategoryId)obj).getCat_name() 
				&& sub_cat_name == ((CategoryId)obj).getSub_cat_name());
	}
	
	
	
}
