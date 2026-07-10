package com.effectivejava.avoidunnecessarychecked;

import java.util.Map;
import java.util.Optional;

public final class OptionalConfigClient {

    private final Map<String, String> values;

    public OptionalConfigClient(Map<String, String> values) {
        this.values = values;
    }

    public Optional<String> fetch(String key) {
        return Optional.ofNullable(values.get(key));
    }
}
