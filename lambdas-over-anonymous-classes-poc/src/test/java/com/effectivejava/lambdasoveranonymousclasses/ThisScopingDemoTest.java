package com.effectivejava.lambdasoveranonymousclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class ThisScopingDemoTest {

    @Test
    void anonymousClassThisRefersToTheAnonymousInstanceNotTheEnclosingOne() {
        ThisScopingDemo demo = new ThisScopingDemo();

        Object anonymousThis = demo.anonymousClassThis();

        assertNotSame(demo, anonymousThis);
    }

    @Test
    void anonymousClassFieldShadowsTheEnclosingInstancesField() {
        ThisScopingDemo demo = new ThisScopingDemo();

        assertEquals("anonymous-class-instance", demo.anonymousClassIdentity());
        assertNotEquals(demo.anonymousClassIdentity(), demo.lambdaIdentity());
    }

    @Test
    void lambdaThisRefersToTheEnclosingInstance() {
        ThisScopingDemo demo = new ThisScopingDemo();

        Object lambdaThis = demo.lambdaThis();

        assertSame(demo, lambdaThis);
    }

    @Test
    void lambdaReadsTheEnclosingInstancesFieldDirectly() {
        ThisScopingDemo demo = new ThisScopingDemo();

        assertEquals("enclosing-instance", demo.lambdaIdentity());
    }
}
