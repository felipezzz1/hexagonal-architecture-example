package com.fezor.shop.adapter.in.rest.cart;

import com.fezor.shop.application.port.in.cart.AddToCartUseCase;
import com.fezor.shop.application.port.in.cart.ProductNotFoundException;
import com.fezor.shop.model.cart.Cart;
import com.fezor.shop.model.cart.NotEnoughItemsInStockException;
import com.fezor.shop.model.customer.CustomerId;
import com.fezor.shop.model.product.ProductId;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static com.fezor.shop.adapter.in.rest.common.ControllerCommons.clientErrorException;
import static com.fezor.shop.adapter.in.rest.common.CustomerIdParser.parseCustomerId;
import static com.fezor.shop.adapter.in.rest.common.ProductIdParser.parseProductId;

@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
public class AddToCartController {

    private final AddToCartUseCase addToCartUseCase;

    public AddToCartController(AddToCartUseCase addToCartUseCase) {
        this.addToCartUseCase = addToCartUseCase;
    }

    @POST
    @Path("/{customerId}/line-items")
    public CartWebModel addLineItem(
        @PathParam("customerId") String customerIdString,
        @QueryParam("productId") String productIdString,
        @QueryParam("quantity") int quantity
    ) {
        CustomerId customerId = parseCustomerId(customerIdString);
        ProductId productId = parseProductId(productIdString);

        try {
            Cart cart = addToCartUseCase.addToCart(customerId, productId, quantity);
            return CartWebModel.fromDomainModel(cart);
        } catch (ProductNotFoundException e) {
            throw clientErrorException(Response.Status.BAD_REQUEST, "The requested product does not exist");
        } catch (NotEnoughItemsInStockException e) {
            throw clientErrorException(
                    Response.Status.BAD_REQUEST,
                    "Only %d items in stock".formatted(e.itemsInStock())
            );
        }
    }
}
