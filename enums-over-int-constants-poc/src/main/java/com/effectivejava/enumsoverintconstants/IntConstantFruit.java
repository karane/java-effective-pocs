package com.effectivejava.enumsoverintconstants;

public final class IntConstantFruit {

    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    private IntConstantFruit() {
        throw new AssertionError();
    }

    public static String describeApple(int appleType) {
        return switch (appleType) {
            case APPLE_FUJI -> "Fuji apple";
            case APPLE_PIPPIN -> "Pippin apple";
            case APPLE_GRANNY_SMITH -> "Granny Smith apple";
            default -> throw new IllegalArgumentException("Unknown apple type: " + appleType);
        };
    }
}
