package com.fezor.shop.application.port.service.cart;

import com.fezor.shop.application.port.in.cart.GetCartUseCase;
import com.fezor.shop.application.port.out.persistence.CartRepository;
import com.fezor.shop.model.cart.Cart;
import com.fezor.shop.model.customer.CustomerId;

import java.util.Objects;

public class GetCartService implements GetCartUseCase {

    private final CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "customerId must not be null");

        return cartRepository
                .findByCustomerId(customerId)
                .orElseGet(() -> new Cart(customerId));
    }
}
