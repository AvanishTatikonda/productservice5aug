package com.example.productservice5aug.services;

import com.example.productservice5aug.models.Product;
import org.springframework.stereotype.Service;

@Service("dbProductService")
public class ProductServiceDBimp implements ProductService{
    @Override
    public Product createProduct(Product product){
        return null;
    }
}
