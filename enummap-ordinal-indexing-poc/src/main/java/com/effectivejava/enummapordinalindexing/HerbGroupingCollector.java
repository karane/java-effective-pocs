package com.effectivejava.enummapordinalindexing;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class HerbGroupingCollector {

    private HerbGroupingCollector() {
        throw new AssertionError();
    }

    public static Map<Herb.Type, Set<Herb>> groupByType(List<Herb> herbs) {
        return herbs.stream().collect(Collectors.groupingBy(
                Herb::type,
                () -> new EnumMap<>(Herb.Type.class),
                Collectors.toSet()));
    }
}
