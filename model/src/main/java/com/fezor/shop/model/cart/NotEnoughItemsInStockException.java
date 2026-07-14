package com.fezor.shop.model.cart;

public class NotEnoughItemsInStockException extends RuntimeException {
    public NotEnoughItemsInStockException(String message) {
        super(message);
    }
}
