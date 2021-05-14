package com.course.spring.security.controllers;

import com.course.spring.security.entities.ProductEntity;
import com.course.spring.security.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsControllers {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return new ResponseEntity<List<ProductEntity>>( productsService.getProductos(), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity prduct){
        return new ResponseEntity<ProductEntity>( productsService.createNewProduct(prduct), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Integer id, @RequestBody ProductEntity product){
        return new ResponseEntity<ProductEntity>(productsService.editProduct(id, product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productsService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
