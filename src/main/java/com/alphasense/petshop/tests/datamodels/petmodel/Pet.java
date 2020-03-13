package com.alphasense.petshop.tests.datamodels.petmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pet {

    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;

	public Pet() {
	}

    public Pet(Integer id, String name, List<String> photoUrls, Category category, List<Tags> tags, String status) {
        this.photoUrls = photoUrls;
        this.name = name;
        this.id = id;
        this.category = category;
        this.tags = tags;
        this.status = status;
    }

    public Pet(Map<String, Object> params) {
        this.name = params.get("petName").toString();
        this.id = Integer.valueOf(params.get("petId").toString());
        this.category = new Category(params);
        this.status = params.get("petStatus").toString();
        this.photoUrls = new ArrayList<>(Arrays.asList(params.get("petPhotoUrls").toString().split(",")));
        this.tags = Arrays.stream(params.get("tags").toString().split(","))
                .map(item -> new Tags(item.split(":")))
                .collect(Collectors.toList());
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pet pet = (Pet) o;
        return Objects.equals(photoUrls, pet.photoUrls) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(id, pet.id) &&
                Objects.equals(category, pet.category) &&
                Objects.equals(tags, pet.tags) &&
                Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoUrls, name, id, status);
    }
}