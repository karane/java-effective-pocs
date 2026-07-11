package com.effectivejava.avoidunnecessarychecked;

public class ConfigFetchRuntimeException extends RuntimeException {

    public ConfigFetchRuntimeException(String key) {
        super("No config value for key: " + key);
    }
}
