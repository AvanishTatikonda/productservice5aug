package com.example.productservice5aug.services.sortingService;

import com.example.productservice5aug.models.Product;

import java.util.List;

public interface Sorter {
    List<Product> sort(List<Product> products);
}
