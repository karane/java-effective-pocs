package com.effectivejava.lambdasoveranonymousclasses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringLengthComparatorsTest {

    @Test
    void anonymousClassComparatorSortsByLength() {
        assertSortsByLength(StringLengthComparators.anonymousClass());
    }

    @Test
    void lambdaComparatorSortsByLength() {
        assertSortsByLength(StringLengthComparators.lambda());
    }

    private void assertSortsByLength(Comparator<String> comparator) {
        List<String> words = new ArrayList<>(List.of("banana", "fig", "kiwi"));
        words.sort(comparator);

        assertEquals(List.of("fig", "kiwi", "banana"), words);
    }
}
