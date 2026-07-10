package com.effectivejava.avoidunnecessarychecked;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptionalConfigClientTest {

    private final OptionalConfigClient client = new OptionalConfigClient(Map.of("timeout", "30"));

    @Test
    void fetchReturnsPresentOptionalForKnownKey() {
        Optional<String> value = client.fetch("timeout");

        assertTrue(value.isPresent());
        assertEquals("30", value.get());
    }

    @Test
    void fetchReturnsEmptyOptionalForUnknownKeyInsteadOfThrowing() {
        Optional<String> value = client.fetch("missing");

        assertFalse(value.isPresent());
    }

    @Test
    void callerCanChainMapAndOrElseWithoutAnyExceptionHandling() {
        int length = client.fetch("timeout").map(String::length).orElse(-1);
        int missingLength = client.fetch("missing").map(String::length).orElse(-1);

        assertEquals(2, length);
        assertEquals(-1, missingLength);
    }
}
