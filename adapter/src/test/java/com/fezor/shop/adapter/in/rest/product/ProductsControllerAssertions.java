package com.fezor.shop.adapter.in.rest.product;

import static jakarta.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.Assertions.assertThat;

import com.fezor.shop.model.product.Product;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;

public final class ProductsControllerAssertions {

    public ProductsControllerAssertions() {
    }

    public static void assertThatResponseIsProduct(Response response, Product product) {
        assertThat(response.statusCode()).isEqualTo(OK.getStatusCode());

        JsonPath json = response.jsonPath();

        assertThatJsonProductMatchesProduct(json, true, "", product);
    }

    public static void assertThatResponseIsProductList(Response response, List<Product> products) {
        assertThat(response.getStatusCode()).isEqualTo(OK.getStatusCode());

        JsonPath json = response.jsonPath();

        for (int i = 0; i < products.size(); i++) {
            String prefix = "[%d].".formatted(i);
            Product product = products.get(i);
            assertThatJsonProductMatchesProduct(json, false, prefix, product);
        }
    }

    static void assertThatJsonProductMatchesProduct(
            JsonPath json, boolean jsonHasDescription, String prefix, Product product
    ) {
        assertThat(json.getString(prefix + "id")).isEqualTo(product.id().value());
        assertThat(json.getString(prefix + "name")).isEqualTo(product.name());

        if (jsonHasDescription) {
            assertThat(json.getString(prefix + "description")).isEqualTo(product.description());
        } else {
            assertThat(json.getString(prefix + "description")).isNull();
        }

        assertThat(json.getString(prefix + "money.currency"))
                .isEqualTo(product.price().currency().getCurrencyCode());
        assertThat(json.getDouble(prefix + "money.amount"))
                .isEqualTo(product.price().amount().doubleValue());

        assertThat(json.getDouble(prefix + "itemsInStock"))
                .isEqualTo(product.itemsInStock());
    }
}
