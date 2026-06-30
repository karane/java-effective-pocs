package com.effectivejava.enumsoverintconstants;

import java.util.List;

public final class EnumCatalog {

    private EnumCatalog() {
        throw new AssertionError();
    }

    public static List<String> describeAllApples() {
        return List.of(Apple.values()).stream()
                .map(FruitDescriber::describe)
                .toList();
    }
}
