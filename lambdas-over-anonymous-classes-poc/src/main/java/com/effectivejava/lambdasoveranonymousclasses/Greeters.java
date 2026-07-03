package com.effectivejava.lambdasoveranonymousclasses;

public final class Greeters {

    private Greeters() {
    }

    public static Runnable anonymousClass(StringBuilder log) {
        return new Runnable() {
            @Override
            public void run() {
                log.append("hello from anonymous class");
            }
        };
    }

    public static Runnable lambda(StringBuilder log) {
        return () -> log.append("hello from lambda");
    }
}
