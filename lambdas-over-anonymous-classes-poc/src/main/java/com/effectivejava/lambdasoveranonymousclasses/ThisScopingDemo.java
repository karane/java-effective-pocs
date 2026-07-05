package com.effectivejava.lambdasoveranonymousclasses;

import java.util.function.Supplier;

public final class ThisScopingDemo {

    private final String identity = "enclosing-instance";

    public Object anonymousClassThis() {
        return new Supplier<Object>() {
            // `this` here is the anonymous class instance, not ThisScopingDemo
            private final String identity = "anonymous-class-instance";

            @Override
            public Object get() {
                return this;
            }
        }.get();
    }

    public String anonymousClassIdentity() {
        return new Supplier<String>() {
            private final String identity = "anonymous-class-instance";

            @Override
            public String get() {
                return identity;
            }
        }.get();
    }

    public Object lambdaThis() {
        // A lambda has no `this` of its own - it captures the enclosing
        // instance's `this`, so the returned reference is ThisScopingDemo itself.
        Supplier<Object> supplier = () -> this;
        return supplier.get();
    }

    public String lambdaIdentity() {
        Supplier<String> supplier = () -> identity;
        return supplier.get();
    }
}
