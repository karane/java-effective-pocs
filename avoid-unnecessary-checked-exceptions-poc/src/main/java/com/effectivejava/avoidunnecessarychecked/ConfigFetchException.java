package com.effectivejava.avoidunnecessarychecked;

public class ConfigFetchException extends Exception {

    public ConfigFetchException(String key) {
        super("No config value for key: " + key);
    }
}
