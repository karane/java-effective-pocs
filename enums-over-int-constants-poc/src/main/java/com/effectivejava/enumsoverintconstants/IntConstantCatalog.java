package com.effectivejava.enumsoverintconstants;

import java.util.ArrayList;
import java.util.List;

public final class IntConstantCatalog {

    public static final int NUMBER_OF_APPLE_TYPES = 3;

    private IntConstantCatalog() {
        throw new AssertionError();
    }

    public static List<String> describeAllApples() {
        List<String> descriptions = new ArrayList<>();
        for (int appleType = 0; appleType < NUMBER_OF_APPLE_TYPES; appleType++) {
            descriptions.add(IntConstantFruit.describeApple(appleType));
        }
        return descriptions;
    }
}
