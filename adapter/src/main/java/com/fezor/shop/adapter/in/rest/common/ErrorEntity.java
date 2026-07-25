package com.fezor.shop.adapter.in.rest.common;

public record ErrorEntity(int httpStatus, String errorMessage) {
}
