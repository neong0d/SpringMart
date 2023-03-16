package com.ecom.spring_mart.product;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(min = 4, message = "Product name should be atleast 4 characters")
    private String title;

    @Size(min = 10, message = "Product description should be atleast 10 characters")
    private String descripton;

    private Integer quantity;

    public Product(@Size(min = 4, message = "Product name should be atleast 4 characters") String title,
            @Size(min = 10, message = "Product description should be atleast 10 characters") String descripton,
            Integer quantity) {
        this.title = title;
        this.descripton = descripton;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescripton() {
        return descripton;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", descripton=" + descripton + ", quantity=" + quantity + "]";
    }
}
