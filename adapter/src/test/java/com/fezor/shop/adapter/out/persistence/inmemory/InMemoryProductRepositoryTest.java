package com.fezor.shop.adapter.out.persistence.inmemory;

import com.fezor.shop.adapter.out.persistence.AbstractProductRepositoryTest;

public class InMemoryProductRepositoryTest extends AbstractProductRepositoryTest<InMemoryProductRepository> {

    @Override
    protected InMemoryProductRepository createProductRepository() {
        return new InMemoryProductRepository();
    }
}
