package com.alphasense.petshop.tests.datamodels.ordermodel;

import java.util.Map;
import java.util.Objects;

public class Order {

    private Integer petId;
    private Integer quantity;
    private Integer id;
    private String shipDate;
    private boolean complete;
    private String status;

    public Order() {
    }

    public Order(Integer petId, Integer quantity, Integer id, String shipDate, boolean complete, String status) {
        this.petId = petId;
        this.quantity = quantity;
        this.id = id;
        this.shipDate = shipDate;
        this.complete = complete;
        this.status = status;
    }

    public Order(Map<String, Object> params) {
        this.petId = Integer.valueOf(params.get("petId").toString());
        this.quantity = Integer.valueOf(params.get("quantity").toString());
        this.id = Integer.valueOf(params.get("orderId").toString());
        this.shipDate = params.get("shipDate").toString();
        this.status = params.get("status").toString();
        this.complete = Boolean.parseBoolean(params.get("complete").toString());
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return complete == order.complete &&
                Objects.equals(petId, order.petId) &&
                Objects.equals(quantity, order.quantity) &&
                Objects.equals(id, order.id) &&
                Objects.equals(shipDate, order.shipDate) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, quantity, id, shipDate, complete, status);
    }
}