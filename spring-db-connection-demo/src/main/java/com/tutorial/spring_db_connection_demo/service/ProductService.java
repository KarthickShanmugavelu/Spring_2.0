package com.tutorial.spring_db_connection_demo.service;

import com.tutorial.spring_db_connection_demo.dto.ProductRecord;
import com.tutorial.spring_db_connection_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductRecord> fetchProducts(String category, BigDecimal price){
        return productRepository.fetchProducts(category,price);
    }
}
