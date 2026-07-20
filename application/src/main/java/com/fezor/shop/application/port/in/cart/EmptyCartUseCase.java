package com.fezor.shop.application.port.in.cart;

import com.fezor.shop.model.customer.CustomerId;

public interface EmptyCartUseCase {
    void emptyCart(CustomerId customerId);
}
