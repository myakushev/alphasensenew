package com.alphasense.petshop.datamodels.petnotfoundmodel;

public class PetNotFound {

    private Integer code;
    private String type;
    private String message;

    public PetNotFound() {
    }

    public PetNotFound(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}