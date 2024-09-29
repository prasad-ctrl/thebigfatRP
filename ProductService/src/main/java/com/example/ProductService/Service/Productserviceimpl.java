package com.example.ProductService.Service;

import com.example.ProductService.Exceptions.ProductduplicateException;
import com.example.ProductService.Exceptions.ProductnullException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repository.ProductRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Productserviceimpl implements ProductService{
    @Autowired
    ProductRepositiry   productRepositiry;

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Product createProduct(String name,String category, String description ) throws ProductnullException, ProductduplicateException {

        Product P = productRepositiry.findByNameAndCategory(name , category);
        if (P !=null ){

            throw new ProductduplicateException(" Product already exists ");

        }
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(description);
        product.setName(name);
        product = productRepositiry.save(product);
        System.out.println(product.getId());
        return product;
    }


}
