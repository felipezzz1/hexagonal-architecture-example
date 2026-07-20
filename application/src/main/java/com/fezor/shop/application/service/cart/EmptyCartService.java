package com.fezor.shop.application.service.cart;

import com.fezor.shop.application.port.in.cart.EmptyCartUseCase;
import com.fezor.shop.application.port.out.persistence.CartRepository;
import com.fezor.shop.model.customer.CustomerId;

import java.util.Objects;

public class EmptyCartService implements EmptyCartUseCase {

    private final CartRepository cartRepository;

    public EmptyCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void emptyCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "customerId must not be null");

        cartRepository.deleteByCustomerId(customerId);
    }
}
