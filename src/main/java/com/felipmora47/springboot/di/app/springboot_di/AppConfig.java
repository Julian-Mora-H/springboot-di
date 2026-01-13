package com.felipmora47.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.felipmora47.springboot.di.app.springboot_di.repositories.IProductRepository;
import com.felipmora47.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties") // Cargar un archivo de propiedades externo
public class AppConfig {

    @Bean("productJson") // Alternativa de crear un componente bean y ponerle un nombre personalizado para el Qualifier
    IProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
