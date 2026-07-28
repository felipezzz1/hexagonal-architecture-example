package com.fezor.shop.bootstrap.e2e;

import static com.fezor.shop.adapter.in.rest.HttpTestCommons.TEST_PORT;

import com.fezor.shop.bootstrap.Launcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

abstract class EndToEndTest {

    private static Launcher launcher;

    @BeforeAll
    static void init() {
        launcher = new Launcher();
        launcher.startOnPort(TEST_PORT);
    }

    @AfterAll
    static void stop() {
        launcher.stop();
    }
}
