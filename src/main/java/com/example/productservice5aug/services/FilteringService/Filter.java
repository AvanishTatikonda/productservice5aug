package com.example.productservice5aug.services.FilteringService;

import com.example.productservice5aug.models.Product;

import java.util.List;

public interface Filter {

    List<Product> apply(
            List<Product> products,
            List<String> values
    );
}