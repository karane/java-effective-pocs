package com.effectivejava.enumsoverintconstants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntConstantFruitTest {

    @Test
    void describesAppleByItsIntConstant() {
        assertEquals("Fuji apple", IntConstantFruit.describeApple(IntConstantFruit.APPLE_FUJI));
        assertEquals("Pippin apple", IntConstantFruit.describeApple(IntConstantFruit.APPLE_PIPPIN));
        assertEquals("Granny Smith apple", IntConstantFruit.describeApple(IntConstantFruit.APPLE_GRANNY_SMITH));
    }

    @Test
    void nothingStopsAnOrangeConstantFromCompilingAsAnAppleArgument() {
        int orangeConstantMisusedAsApple = IntConstantFruit.ORANGE_NAVEL;

        assertEquals("Fuji apple", IntConstantFruit.describeApple(orangeConstantMisusedAsApple));
    }

    @Test
    void anOutOfRangeIntFailsOnlyAtRuntime() {
        assertThrows(IllegalArgumentException.class, () -> IntConstantFruit.describeApple(99));
    }
}
