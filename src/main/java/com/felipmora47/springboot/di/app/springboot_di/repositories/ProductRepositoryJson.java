package com.felipmora47.springboot.di.app.springboot_di.repositories;

import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.felipmora47.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements IProductRepository {

    
    private List<Product> list;

    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }


}
