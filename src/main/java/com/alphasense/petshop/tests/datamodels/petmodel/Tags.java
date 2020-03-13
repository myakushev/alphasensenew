package com.alphasense.petshop.tests.datamodels.petmodel;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Tags tags = (Tags) o;
		return Objects.equals(name, tags.name) &&
				Objects.equals(id, tags.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}
}