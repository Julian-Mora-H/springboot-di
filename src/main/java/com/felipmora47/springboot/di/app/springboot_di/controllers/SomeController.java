package com.felipmora47.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.felipmora47.springboot.di.app.springboot_di.models.Product;
import com.felipmora47.springboot.di.app.springboot_di.services.IProductService;
//import com.felipmora47.springboot.di.app.springboot_di.services.ProductServiceImpl;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class SomeController {
    

    //Instancia de la clase ProductServiceImpl
    /*   private ProductServiceImpl service = new ProductServiceImpl();*/

    //Inyección de dependencias de la clase ProductServiceImplvb  
    /* @Autowired
    private ProductServiceImpl service; */


    //Inyección de dependencias de la interfaz IProductService
    //@Autowired
    private IProductService service;

    //Inyección de dependecias atravez de un setter
    //@Autowired
    /*  public void setService(IProductService service) {
        this.service = service;
    } */

    //Inyección de dependecias atra vez de un constructor y no es necesario el @Autowired
    public SomeController(IProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }

   

}
