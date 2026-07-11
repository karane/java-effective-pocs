package com.effectivejava.avoidunnecessarychecked;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UncheckedConfigClientTest {

    private final UncheckedConfigClient client = new UncheckedConfigClient(Map.of("timeout", "30"));

    @Test
    void fetchReturnsValueForKnownKey() {
        assertEquals("30", client.fetch("timeout"));
    }

    @Test
    void fetchThrowsUncheckedExceptionForUnknownKey() {
        assertThrows(ConfigFetchRuntimeException.class, () -> client.fetch("missing"));
    }

    @Test
    void callSitesThatDoNotExpectFailureNeedNoTryCatch() {
        assertEquals(2, client.fetch("timeout").length());
    }
}
