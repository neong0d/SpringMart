package com.ecom.spring_mart.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.spring_mart.product.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {}
