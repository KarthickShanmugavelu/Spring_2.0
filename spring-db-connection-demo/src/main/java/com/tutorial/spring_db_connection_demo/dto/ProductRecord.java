package com.tutorial.spring_db_connection_demo.dto;

import java.math.BigDecimal;

public record ProductRecord(Long id,
                            String name,
                            String category,
                            BigDecimal price) {
}
