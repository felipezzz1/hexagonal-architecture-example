package com.fezor.shop.bootstrap;

import com.fezor.shop.adapter.in.rest.cart.AddToCartController;
import com.fezor.shop.adapter.in.rest.cart.EmptyCartController;
import com.fezor.shop.adapter.in.rest.cart.GetCartController;
import com.fezor.shop.adapter.in.rest.product.FindProductsController;
import com.fezor.shop.adapter.out.persistence.inmemory.InMemoryCartRepository;
import com.fezor.shop.adapter.out.persistence.inmemory.InMemoryProductRepository;
import com.fezor.shop.application.port.in.cart.AddToCartUseCase;
import com.fezor.shop.application.port.in.cart.EmptyCartUseCase;
import com.fezor.shop.application.port.in.cart.GetCartUseCase;
import com.fezor.shop.application.port.in.product.FindProductsUseCase;
import com.fezor.shop.application.port.out.persistence.CartRepository;
import com.fezor.shop.application.port.out.persistence.ProductRepository;
import com.fezor.shop.application.service.cart.AddToCartService;
import com.fezor.shop.application.service.cart.EmptyCartService;
import com.fezor.shop.application.service.cart.GetCartService;
import com.fezor.shop.application.service.product.FindProductsService;
import jakarta.ws.rs.core.Application;

import java.util.Set;

public class RestEasyUndertowShopApplication extends Application {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @Override
    public Set<Object> getSingletons() {
        initPersistenceAdapters();

        return Set.of(
                addToCartController(),
                getCartController(),
                emptyCartController(),
                findProductsController());
    }

    private void initPersistenceAdapters() {
        cartRepository = new InMemoryCartRepository();
        productRepository = new InMemoryProductRepository();
    }

    private AddToCartController addToCartController() {
        AddToCartUseCase addToCartUseCase =
                new AddToCartService(cartRepository, productRepository);

        return new AddToCartController(addToCartUseCase);
    }

    private GetCartController getCartController() {
        GetCartUseCase getCartUseCase = new GetCartService(cartRepository);
        return new GetCartController(getCartUseCase);
    }

    private EmptyCartController emptyCartController() {
        EmptyCartUseCase emptyCartUseCase = new EmptyCartService(cartRepository);
        return new EmptyCartController(emptyCartUseCase);
    }

    private FindProductsController findProductsController() {
        FindProductsUseCase findProductsUseCase = new FindProductsService(productRepository);
        return new FindProductsController(findProductsUseCase);
    }
}
