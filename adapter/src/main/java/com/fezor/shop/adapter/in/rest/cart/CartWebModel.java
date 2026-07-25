package com.fezor.shop.adapter.in.rest.cart;

import com.fezor.shop.model.cart.Cart;
import com.fezor.shop.model.cart.CartLineItem;
import com.fezor.shop.model.money.Money;

import java.util.List;

public record CartWebModel(List<CartLineItemWebModel> lineItems, int numberOfItems, Money subTotal) {

    static CartWebModel fromDomainModel(Cart cart) {
        return new CartWebModel(
                cart.lineItems().stream().map(CartLineItemWebModel::fromDomainModel).toList(),
                cart.numberOfItems(),
                cart.subTotal()
        );
    }
}
