package com.fezor.shop.adapter.in.rest.product;

import com.fezor.shop.model.money.Money;
import com.fezor.shop.model.product.Product;

public record ProductInListWebModel(String id, String name, Money money, int itemsInStock) {

    public static ProductInListWebModel fromDomainModel(Product product) {
        return new ProductInListWebModel(
                product.id().value(), product.name(), product.price(), product.itemsInStock()
        );
    }
}
