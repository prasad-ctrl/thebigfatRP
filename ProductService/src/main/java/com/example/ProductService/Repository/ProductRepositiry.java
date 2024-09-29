package com.example.ProductService.Repository;

import com.example.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepositiry extends JpaRepository  <Product, Long> {
    //select * from products name = {name)
   // Product findByName(String name);
    Product findByNameAndCategory(String name, String category);
    //List<Product> findAll();
    //Product findById(long id);
}
