package com.example.productservice5aug.services.sortingService;

import com.example.productservice5aug.models.Product;

import java.util.Comparator;
import java.util.List;

public class PriceHighToLowSorter implements Sorter{
    @Override
    public List<Product> sort(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
    }
}
