package com.example.productservice5aug.services.FilteringService;

import com.example.productservice5aug.models.Product;

import java.util.ArrayList;
import java.util.List;

public class BrandFilter implements Filter {

    @Override
    public List<Product> apply(
            List<Product> products,
            List<String> allowedValues
    ) {

        List<Product> ans = new ArrayList<>();

        for (Product product : products) {

            for (String value : allowedValues) {

                if (product.getBrand() != null &&
                        product.getBrand().equalsIgnoreCase(value))  {
                    ans.add(product);
                    break;
                }
            }
        }

        return ans;
    }
}