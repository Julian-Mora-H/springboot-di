package com.felipmora47.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties") // Cargar un archivo de propiedades externo
public class AppConfig {

}
