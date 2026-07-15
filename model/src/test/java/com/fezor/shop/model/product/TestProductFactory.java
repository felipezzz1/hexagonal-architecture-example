package com.fezor.shop.model.product;

import com.fezor.shop.model.money.Money;

public class TestProductFactory {

    private static final int ENOUGH_ITEMS_IN_STOCK = Integer.MAX_VALUE;

    public static Product createTestProduct(Money price) {
        return createTestProduct(price, ENOUGH_ITEMS_IN_STOCK);
    }

    public static Product createTestProduct(Money price, int itemsInStock) {
        return new Product(
                ProductId.randomProductId(),
                "any product",
                "any description",
                price,
                itemsInStock
        );
    }
}
