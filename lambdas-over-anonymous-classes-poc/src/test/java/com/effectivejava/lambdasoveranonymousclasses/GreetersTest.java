package com.effectivejava.lambdasoveranonymousclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetersTest {

    @Test
    void anonymousClassRunnableAppendsToLog() {
        StringBuilder log = new StringBuilder();
        Greeters.anonymousClass(log).run();

        assertEquals("hello from anonymous class", log.toString());
    }

    @Test
    void lambdaRunnableAppendsToLog() {
        StringBuilder log = new StringBuilder();
        Greeters.lambda(log).run();

        assertEquals("hello from lambda", log.toString());
    }
}
