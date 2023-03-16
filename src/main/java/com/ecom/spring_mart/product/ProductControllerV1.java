package com.ecom.spring_mart.product;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.spring_mart.jpa.ProductRepository;

@RestController
public class ProductControllerV1 {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/v1/products")
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/v1/products/{id}")
    public EntityModel<Product> retrieveProduct(@PathVariable UUID id) {
      Optional<Product> product = productRepository.findById(id);

      EntityModel<Product> entityModel = EntityModel.of(product.get());
      WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllProducts());
      entityModel.add(link.withRel("all-products"));

      return entityModel;
    }
}
