package com.felipmora47.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipmora47.springboot.di.app.springboot_di.models.Product;
import com.felipmora47.springboot.di.app.springboot_di.repositories.IProductRepository;
//import com.felipmora47.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private Environment environment;// Primera Forma : Para acceder a las propiedades del archivo config.properties 
    //@Value("${config.price.tax}") // Segunda Forma : Para acceder a las propiedades del archivo config.properties
    //private Double tax; 

    private IProductRepository repository;
    
    //Inyección de dependecias atravez de un constructor y no es necesario el @Autowired
    public ProductServiceImpl(@Qualifier("productJson") IProductRepository repository) {
        this.repository = repository;
    }

    //Instancia de la clase ProductRepositoryImpl
   /*  private ProductRepositoryImpl repository = new ProductRepositoryImpl(); */

    //Inyección de dependencias de la clase ProductRepositoryImpl
    /* @Autowired
    private ProductRepositoryImpl repository; */

    //Inyección de dependencias de la interfaz IProductRepository
    //@Autowired 
    //@Qualifier("productList") //Para indicar cual es el repositorio que se va a utilizar en caso de tener varios, superando al @Primary del repositorio principal
    //private IProductRepository repository;  

    
    //Inyección de dependecias atravez de un setter
    /*  @Autowired
    public void setRepository(IProductRepository repository) {
        this.repository = repository;
    } */

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            // System.out.println(tax); Verificar que se inyecta bien la propiedad
            Double priceTax = p.getPrice()  * environment.getProperty("config.price.tax",Double.class);

            // Para que no ocurra inmutabilidad en el objeto original
            /* Product newProd = new Product(p.getId(),p.getName(),priceImp.longValue()); */

            //Otra forma de hacer para que no ocurra inmutabilidad en el objeto original
            Product newProd = (Product)p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;

            // Esta forma no es inmutable
            // p.setPrice(priceTax.longValue());
            // return p;

        }).collect(Collectors.toList());
    }


    @Override
    public Product findById (Long id){
        return repository.findById(id);
    }

}