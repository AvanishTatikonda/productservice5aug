package com.example.productservice5aug.repositories;

import com.example.productservice5aug.models.Product;
//import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product p);// the attributes that are automatically generated
    // by db will not be in the param,but will be there
    //in the returned object


    List<Product> findAllByTitle(String title);

    List<Product> findByCreatedAtIsNotNullAndDescription(String description);

    List<Product> findByIdIs(Long id);
    List<Product> findByTitleContaining(String query);
    Page<Product> findByTitleContaining(String query, Pageable pageable);
}
