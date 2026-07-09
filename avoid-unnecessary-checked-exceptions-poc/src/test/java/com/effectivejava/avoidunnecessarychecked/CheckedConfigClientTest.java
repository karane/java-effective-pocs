package com.effectivejava.avoidunnecessarychecked;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckedConfigClientTest {

    private final CheckedConfigClient client = new CheckedConfigClient(Map.of("timeout", "30"));

    @Test
    void fetchReturnsValueForKnownKey() throws ConfigFetchException {
        assertEquals("30", client.fetch("timeout"));
    }

    @Test
    void fetchThrowsCheckedExceptionForUnknownKey() {
        assertThrows(ConfigFetchException.class, () -> client.fetch("missing"));
    }

    @Test
    void everyCallSiteMustDeclareOrCatchTheCheckedException() {
        int result;
        try {
            result = client.fetch("timeout").length();
        } catch (ConfigFetchException e) {
            result = -1;
        }
        assertEquals(2, result);
    }
}
