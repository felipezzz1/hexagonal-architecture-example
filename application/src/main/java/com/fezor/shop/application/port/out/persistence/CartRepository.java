package com.fezor.shop.application.port.out.persistence;

import com.fezor.shop.model.cart.Cart;
import com.fezor.shop.model.customer.CustomerId;

import java.util.Optional;

public interface CartRepository {

    void save (Cart cart);

    Optional<Cart> findByCustomerId(CustomerId customerId);
}
