package com.alphasense.petshop.datamodels.petmodel;

import java.util.Map;

public class Category{
	
	private String name;
	private Integer id;

	public Category() {
	}

	public Category(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public Category(Map<String, String> params) {
		this.name = params.get("categoryName");
		this.id = Integer.valueOf(params.get("categoryId"));
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}
}