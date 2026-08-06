package com.example.productservice5aug.services;

import com.example.productservice5aug.dtos.CreateProductRequestDto;
import com.example.productservice5aug.models.Product;

public interface ProductService {

    Product createProduct(Product product);
}
