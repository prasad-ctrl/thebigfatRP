package com.example.ProductService.Advice;

import com.example.ProductService.Exceptions.ProductduplicateException;
import com.example.ProductService.Exceptions.Productexception;
import com.example.ProductService.Exceptions.ProductnullException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(Productexception.class)
    public ResponseEntity<String> getproductexception (Productexception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(ProductduplicateException.class)
    public ResponseEntity<String> getproductduplicateexception (ProductduplicateException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatusCode.valueOf(400));

    }
    @ExceptionHandler(ProductnullException.class)
        public ResponseEntity<String> getproductnullexception (ProductnullException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatusCode.valueOf(400));
    }
}
