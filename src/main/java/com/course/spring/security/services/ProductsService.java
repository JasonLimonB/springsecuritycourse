package com.course.spring.security.services;

import com.course.spring.security.entities.ProductEntity;
import com.course.spring.security.repositories.IProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private IProducts iProducts;

    public List<ProductEntity> getProductos(){
        return iProducts.findAll();
    }

    public ProductEntity createNewProduct(ProductEntity product){
        return iProducts.save(product);
    }

    public ProductEntity editProduct( Integer id, ProductEntity product ){
        Optional<ProductEntity> response = iProducts.findById(id);
        if( response.isPresent() )
            return iProducts.save(product);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The product with id %s doesn't exist", id));
    }

    public void deleteProduct( Integer id ){
        Optional<ProductEntity> result = iProducts.findById(id);
        if(result.isPresent())
            iProducts.delete(result.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user with ID %s doesn't exist", id));
    }

}
