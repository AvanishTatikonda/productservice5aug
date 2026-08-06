package com.example.productservice5aug.controllers;

import com.example.productservice5aug.dtos.CreateProductRequestDto;
import com.example.productservice5aug.dtos.CreateProductResponseDto;
import com.example.productservice5aug.models.Product;
import com.example.productservice5aug.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("fakestoreProductService")ProductService productService){
        this.productService=productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product=productService.createProduct(
                createProductRequestDto.toProduct()
        );

        return CreateProductResponseDto.fromProduct(product);
       //return "this product is priced at :" +createProductRequestDto.getPrice();
    }
    @GetMapping("")
    public  void getAllproducts(){

    }
    @GetMapping("{id}")
    public String getSingleProduct(@PathVariable("id") Long id){
        return "here is ur product";
    }

//    @RequestMapping(name="AVANISH",value="/products/")
//    public String dkcsdlk(){
//        return "hello";
//    }
}
