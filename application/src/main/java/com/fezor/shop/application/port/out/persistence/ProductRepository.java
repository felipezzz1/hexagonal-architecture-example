package com.fezor.shop.application.port.out.persistence;

import com.fezor.shop.model.product.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findByNameOrDescription(String query);
}
