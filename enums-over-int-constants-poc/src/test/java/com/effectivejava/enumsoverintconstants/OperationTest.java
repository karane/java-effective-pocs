package com.effectivejava.enumsoverintconstants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationTest {

    @Test
    void eachConstantAppliesItsOwnConstantSpecificBehavior() {
        assertEquals(5.0, Operation.PLUS.apply(2.0, 3.0));
        assertEquals(-1.0, Operation.MINUS.apply(2.0, 3.0));
        assertEquals(6.0, Operation.TIMES.apply(2.0, 3.0));
        assertEquals(2.0, Operation.DIVIDE.apply(6.0, 3.0));
    }

    @Test
    void eachConstantCarriesItsOwnSymbolAlongsideItsBehavior() {
        assertEquals("+", Operation.PLUS.symbol());
        assertEquals("-", Operation.MINUS.symbol());
        assertEquals("*", Operation.TIMES.symbol());
        assertEquals("/", Operation.DIVIDE.symbol());
    }
}
