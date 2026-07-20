package com.fezor.shop.application.port.in.cart;

import com.fezor.shop.model.cart.Cart;
import com.fezor.shop.model.customer.CustomerId;

public interface GetCartUseCase {
    Cart getCart(CustomerId customerId);
}
