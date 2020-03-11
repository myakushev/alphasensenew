package com.alphasense.petshop.dataModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
//@AllArgsConstructor
public class Pet {

    private String name;

    private Integer id;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public Pet(String name, Integer id, Category category, List<String> photoUrls, List<Tag> tags, String status) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    private static final Logger logger = LoggerFactory.getLogger(Pet.class);


    public String petToJson(JsonInclude.Include include) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(include);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.info("Can't create JSON");
        }
        return json;
    }

    public static Pet jsonToPet(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Pet pet = null;
        try {
            pet = objectMapper.readValue(json, Pet.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Can't parse JSON");
        }
        return pet;
    }

    public static Pet createPetFromMap(Map<String, String> entry) {
        return Pet.builder()
                .name(getValue(entry.get("petName")))
                .id(Integer.parseInt(getValue(entry.get("petId"))))
                .category(
                        Category.builder()
                                .id(Integer.parseInt(getValue(entry.get("categoryId"))))
                                .name(getValue(entry.get("categoryName")))
                                .build()
                )
                .photoUrls(Arrays.asList(entry.get("petPhotoUrls").split(",")))
                .tags(
                        Arrays.asList(Tag.builder()
                                .id(Integer.parseInt(getValue(entry.get("tagId"))))
                                .name(getValue(entry.get("tagName")))
                                .build())
                )
                .status(getValue(entry.get("petStatus")))
                .build();
    }

    public static String getValue(String s) {
        if (s.equals("null")
        ) {
            return null;
        } else {
            return s;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) &&
                Objects.equals(id, pet.id) &&
                Objects.equals(category, pet.category) &&
                Objects.equals(photoUrls, pet.photoUrls) &&
                Objects.equals(tags, pet.tags) &&
                Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, category, photoUrls, tags, status);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

