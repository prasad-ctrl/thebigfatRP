package com.example.ProductService.Service;


import com.example.ProductService.Exceptions.ProductduplicateException;
import com.example.ProductService.Exceptions.ProductnullException;
import com.example.ProductService.Models.Product;

public interface ProductService {
    public Product getProductById(long  id);
    public Product createProduct(String name,String category, String description ) throws ProductnullException , ProductduplicateException;

}
