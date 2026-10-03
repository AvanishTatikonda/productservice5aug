package com.example.productservice5aug.services.FilteringService;

import com.example.productservice5aug.models.Product;

import java.util.ArrayList;
import java.util.List;

public class RamFilter implements Filter {

    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        List<Product> ans = new ArrayList<>();

        for (Product product : products) {
            for (String value : allowedValues) {
                if (product.getRam() != null &&
                        product.getRam().equalsIgnoreCase(value)) {
                    ans.add(product);
                    break;
                }
            }
        }

        return ans;
    }
}