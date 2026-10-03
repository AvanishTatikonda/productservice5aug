package com.example.productservice5aug.dtos;

import com.example.productservice5aug.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;
    private String brand;
    private String ram;
    public Product toProduct() {
        Product product = new Product();

        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
       product.setCategoryName(this.categoryName);
        product.setBrand(this.brand);
        product.setRam(this.ram);

        return product;
    }
}
