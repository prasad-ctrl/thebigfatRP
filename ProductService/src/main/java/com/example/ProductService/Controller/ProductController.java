package com.example.ProductService.Controller;

import com.example.ProductService.Dto.Createproductdto;
import com.example.ProductService.Exceptions.ProductduplicateException;
import com.example.ProductService.Exceptions.Productexception;
import com.example.ProductService.Exceptions.ProductnullException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public Product createProduct(@RequestBody Createproductdto crtdto) throws ProductnullException , ProductduplicateException {
        //Basic Validation
        if(crtdto.getName() == null || crtdto.getCategory()==null || crtdto.getDescription() == null ){
            throw new ProductnullException("Product name and category are required");
        }

        return productService.createProduct(crtdto.getName() , crtdto.getCategory(), crtdto.getDescription());
    }

}
