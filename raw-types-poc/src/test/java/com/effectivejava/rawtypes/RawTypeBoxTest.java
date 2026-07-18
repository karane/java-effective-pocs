package com.effectivejava.rawtypes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RawTypeBoxTest {

    @Test
    void rawListAcceptsHeterogeneousTypes() {
        List<?> raw = RawTypeBox.makeRawList();
        assertEquals(2, raw.size());
    }

    @Test
    void objectListAcceptsHeterogeneousTypes() {
        List<Object> list = RawTypeBox.makeObjectList();
        assertEquals(2, list.size());
        assertEquals("hello", list.get(0));
        assertEquals(42, list.get(1));
    }

    @Test
    void wildcardCountWorksForAnyParameterization() {
        List<String> strings = List.of("a", "b", "c");
        List<Integer> ints = List.of(1, 2, 3);
        assertEquals(3, RawTypeBox.countElements(strings));
        assertEquals(3, RawTypeBox.countElements(ints));
    }

    @Test
    void extractStringUnsafeSucceedsWhenTypeMatches() {
        @SuppressWarnings("rawtypes")
        List raw = new ArrayList();
        raw.add("product-name");
        assertEquals("product-name", RawTypeBox.extractStringUnsafe(raw, 0));
    }

    @Test
    void extractStringUnsafeThrowsClassCastExceptionWhenTypeMismatches() {
        @SuppressWarnings("rawtypes")
        List raw = new ArrayList();
        raw.add(99);
        assertThrows(ClassCastException.class, () -> RawTypeBox.extractStringUnsafe(raw, 0));
    }

    @Test
    void objectListRejectsStringListAssignment() {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        List<Object> objects = new ArrayList<>(strings);
        objects.add(123);
        assertEquals(2, objects.size());
    }

    @Test
    void wildcardListIsReadableButNotWritable() {
        List<String> strings = List.of("grape", "melon");
        List<?> wildcard = strings;
        assertEquals(2, wildcard.size());
        assertEquals("grape", wildcard.get(0));
    }
}
