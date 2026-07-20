package com.fezor.shop.application.port.service.product;

import com.fezor.shop.application.port.in.product.FindProductsUseCase;
import com.fezor.shop.application.port.out.persistence.ProductRepository;
import com.fezor.shop.model.product.Product;

import java.util.List;
import java.util.Objects;

public class FindProductsService implements FindProductsUseCase {

    private final ProductRepository productRepository;

    public FindProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByNameOrDescription(String query) {
        Objects.requireNonNull(query, "query must not be null");
        if (query.length() < 2) {
            throw new IllegalArgumentException("query must be at least two characters long");
        }

        return productRepository.findByNameOrDescription(query);
    }
}
