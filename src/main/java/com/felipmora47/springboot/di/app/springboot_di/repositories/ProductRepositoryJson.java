package com.felipmora47.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipmora47.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements IProductRepository {

    
    private List<Product> list;

    // @Value("json/product.json") // Funciona solo si se usa en un componente spring
    // private ClassPathResource resource; forma declarativa de cargar un recurso desde el classpath

    public ProductRepositoryJson() {

        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             // list = Arrays.asList(objectMapper.readValue(resource.getFile(),Product[].class)); traer una lista desde un archivo json con getFile()
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(),Product[].class)); // traer una lista desde un archivo json con getInputStream()
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }


}
