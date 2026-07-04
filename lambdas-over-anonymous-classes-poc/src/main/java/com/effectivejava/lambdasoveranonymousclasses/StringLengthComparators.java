package com.effectivejava.lambdasoveranonymousclasses;

import java.util.Comparator;

public final class StringLengthComparators {

    private StringLengthComparators() {
    }

    public static Comparator<String> anonymousClass() {
        return new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }
        };
    }

    public static Comparator<String> lambda() {
        return (a, b) -> Integer.compare(a.length(), b.length());
    }
}
