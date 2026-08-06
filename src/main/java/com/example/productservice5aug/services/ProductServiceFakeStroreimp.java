package com.example.productservice5aug.services;

import com.example.productservice5aug.dtos.CreateProductRequestDto;
import com.example.productservice5aug.dtos.FakeStoreCreateProductRequestDto;
import com.example.productservice5aug.dtos.FakeStoreCreateProductResponseDto;
import com.example.productservice5aug.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakestoreProductService")
public class ProductServiceFakeStroreimp implements ProductService {
    private RestTemplate restTemplate;

    public ProductServiceFakeStroreimp(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public Product createProduct(Product product){
        FakeStoreCreateProductRequestDto request=new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setTitle(product.getTitle());
        request.setImage(product.getImageUrl());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());

        FakeStoreCreateProductResponseDto response=restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class

        );
        Product product1=new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setCategoryName(response.getCategory());
        product1.setImageUrl(response.getImage());
        product1.setPrice(response.getPrice());
        return product1;
    }
}
