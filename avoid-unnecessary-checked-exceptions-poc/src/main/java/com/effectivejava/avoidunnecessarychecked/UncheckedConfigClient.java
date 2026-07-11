package com.effectivejava.avoidunnecessarychecked;

import java.util.Map;

public final class UncheckedConfigClient {

    private final Map<String, String> values;

    public UncheckedConfigClient(Map<String, String> values) {
        this.values = values;
    }

    public String fetch(String key) {
        String value = values.get(key);
        if (value == null) {
            throw new ConfigFetchRuntimeException(key);
        }
        return value;
    }
}
