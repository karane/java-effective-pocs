package com.effectivejava.enumsoverintconstants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AppleTest {

    @Test
    void nameReturnsTheDeclaredConstantName() {
        assertEquals("GRANNY_SMITH", Apple.GRANNY_SMITH.name());
    }

    @Test
    void ordinalReflectsDeclarationOrder() {
        assertEquals(0, Apple.FUJI.ordinal());
        assertEquals(1, Apple.PIPPIN.ordinal());
        assertEquals(2, Apple.GRANNY_SMITH.ordinal());
    }

    @Test
    void valuesReturnsAllConstantsInDeclarationOrder() {
        assertEquals(3, Apple.values().length);
        assertSame(Apple.FUJI, Apple.values()[0]);
        assertSame(Apple.GRANNY_SMITH, Apple.values()[2]);
    }

    @Test
    void valueOfResolvesAConstantByName() {
        assertSame(Apple.PIPPIN, Apple.valueOf("PIPPIN"));
    }
}
