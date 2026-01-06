package com.felipmora47.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.felipmora47.springboot.di.app.springboot_di.models.Product;

// @Primary indica cual es el Repositorio principal el cual se va a inyectar
//@Primary
@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Product Foo", 1000L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Product Foo", 1000L);
    }



}
