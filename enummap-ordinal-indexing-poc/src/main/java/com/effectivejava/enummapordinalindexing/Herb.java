package com.effectivejava.enummapordinalindexing;

public record Herb(String name, Type type) {

    public enum Type {
        ANNUAL, PERENNIAL, BIENNIAL
    }
}
