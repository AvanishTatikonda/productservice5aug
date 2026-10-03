package com.example.productservice5aug.services;

import com.example.productservice5aug.dtos.search.SortingCriteria;
import com.example.productservice5aug.models.Product;
import com.example.productservice5aug.repositories.ProductRepository;
import com.example.productservice5aug.services.sortingService.Sorter;
import com.example.productservice5aug.services.sortingService.SorterFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(
            String query,
            Long categoryId,
            int pageNumber,
            int pageSize,
            SortingCriteria sortingCriteria
    ) {

        // 1. Get all products matching the search query
        List<Product> products;
        if(categoryId==null){
            products=productRepository.findByTitleContaining(query);
        }else {
            products = productRepository.findAllByTitleContainingAndCategory_Id(
                            query,
                            categoryId
                    );
        }
        // 2. Find which sorter we need
        Sorter sorter =
                SorterFactory.getSorterByCriteria(sortingCriteria);

        // 3. Sort the products
        products = sorter.sort(products);

        // 4. Calculate which part of the sorted list belongs to this page
        int start = pageNumber * pageSize;
        int end = Math.min(start + pageSize, products.size());

        List<Product> productsOnPage =
                new ArrayList<>();

        if (start < products.size()) {
            productsOnPage.addAll(
                    products.subList(start, end)
            );
        }

        //here we create a page object
        PageRequest pageRequest =
                PageRequest.of(pageNumber, pageSize);

        return new PageImpl<>(
                productsOnPage,
                pageRequest,
                products.size()
        );
    }
}