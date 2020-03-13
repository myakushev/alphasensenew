package com.alphasense.petshop.tests.datamodels.petmodel;

import java.util.Map;
import java.util.Objects;

public class Category{
	
	private String name;
	private Integer id;

	public Category() {
	}

	public Category(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public Category(Map<String, Object> params) {
		this.name = params.get("categoryName").toString();
		this.id = Integer.valueOf(params.get("categoryId").toString());
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Category category = (Category) o;
		return Objects.equals(name, category.name) &&
				Objects.equals(id, category.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}
}