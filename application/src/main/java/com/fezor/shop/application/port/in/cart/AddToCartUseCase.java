package com.fezor.shop.application.port.in.cart;

import com.fezor.shop.model.cart.Cart;
import com.fezor.shop.model.cart.NotEnoughItemsInStockException;
import com.fezor.shop.model.customer.CustomerId;
import com.fezor.shop.model.product.ProductId;

public interface AddToCartUseCase {

    Cart addToCart(CustomerId customerId, ProductId productId, int quantity) throws ProductNotFoundException, NotEnoughItemsInStockException;
}
