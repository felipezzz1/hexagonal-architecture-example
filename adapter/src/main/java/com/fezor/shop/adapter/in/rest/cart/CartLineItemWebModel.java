package com.fezor.shop.adapter.in.rest.cart;

import com.fezor.shop.model.cart.CartLineItem;
import com.fezor.shop.model.money.Money;
import com.fezor.shop.model.product.Product;

public record CartLineItemWebModel(String productId, String productName, Money price, int quantity) {

    public static CartLineItemWebModel fromDomainModel(CartLineItem lineItem) {
        Product product = lineItem.product();
        return new CartLineItemWebModel(
                product.id().value(), product.name(), product.price(), lineItem.quantity()
        );
    }
}
