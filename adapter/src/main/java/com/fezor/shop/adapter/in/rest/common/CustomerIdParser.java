package com.fezor.shop.adapter.in.rest.common;

import static com.fezor.shop.adapter.in.rest.common.ControllerCommons.clientErrorException;

import com.fezor.shop.model.customer.CustomerId;
import jakarta.ws.rs.core.Response;

public final class CustomerIdParser {

    public CustomerIdParser() {
    }

    public static CustomerId parseCustomerId(String string) {
        try {
            return new CustomerId(Integer.parseInt(string));
        } catch (IllegalArgumentException e) {
            throw clientErrorException(Response.Status.BAD_REQUEST, "Invalid customerId");
        }
    }
}
