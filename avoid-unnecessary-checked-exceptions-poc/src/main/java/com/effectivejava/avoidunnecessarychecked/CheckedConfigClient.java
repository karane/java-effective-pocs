package com.effectivejava.avoidunnecessarychecked;

import java.util.Map;

public final class CheckedConfigClient {

    private final Map<String, String> values;

    public CheckedConfigClient(Map<String, String> values) {
        this.values = values;
    }

    public String fetch(String key) throws ConfigFetchException {
        String value = values.get(key);
        if (value == null) {
            throw new ConfigFetchException(key);
        }
        return value;
    }
}
