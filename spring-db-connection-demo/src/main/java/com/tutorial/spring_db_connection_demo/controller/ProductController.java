package com.tutorial.spring_db_connection_demo.controller;

import com.tutorial.spring_db_connection_demo.dto.ProductRecord;
import com.tutorial.spring_db_connection_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("getProducts")
    public ResponseEntity<List<ProductRecord>> fetchProducts(@RequestBody ProductRecord productRecord){
        List<ProductRecord> respPrdRec = productService.fetchProducts(productRecord.category(),productRecord.price());
        return new ResponseEntity<>(respPrdRec, HttpStatus.OK);
    }
}
