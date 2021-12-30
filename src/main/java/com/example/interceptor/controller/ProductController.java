package com.example.interceptor.controller;

import com.example.interceptor.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    public static List<Product> products = new ArrayList<>();
    static {
        Product product1 = new Product(1, "A");
        Product product2 = new Product(2, "B");
        Product product3 = new Product(3, "B");
        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    @GetMapping("/product")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}



