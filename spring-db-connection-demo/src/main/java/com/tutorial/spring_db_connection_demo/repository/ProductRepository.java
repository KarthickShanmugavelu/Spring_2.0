package com.tutorial.spring_db_connection_demo.repository;

import com.tutorial.spring_db_connection_demo.dto.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepository {

    @Value("${product.select.query}")
    public String productSelectQuery;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ProductRecord> fetchProducts(String category, BigDecimal price){

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("productCategory",category)
                .addValue("maxProdPrice",price);

        return namedParameterJdbcTemplate.query(productSelectQuery,parameters,(rs,rowNum)->
            new ProductRecord(rs.getLong("id"),rs.getString("name"),rs.getString("category"),rs.getBigDecimal("price")));
        }
}
