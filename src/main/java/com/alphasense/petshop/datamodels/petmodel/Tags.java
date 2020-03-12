package com.alphasense.petshop.datamodels.petmodel;

import java.util.List;

public class Tags {
	
	private String name;
	private Integer id;

	public Tags() {
	}

	public Tags(String[] arrayOfFields) {
		this.name = arrayOfFields[1];
		this.id = Integer.valueOf(arrayOfFields[0]);
	}

	public Tags(String name, Integer id) {
		this.name = name;
		this.id = id;
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