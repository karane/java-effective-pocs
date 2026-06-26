package com.effectivejava.enummapordinalindexing;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class EnumMapHerbGarden {

    public static Map<Herb.Type, Set<Herb>> groupByType(List<Herb> herbs) {
        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<>(Herb.Type.class);
       
        for (Herb.Type type : Herb.Type.values()) {
            herbsByType.put(type, new HashSet<>());
        }
       
        for (Herb herb : herbs) {
            herbsByType.get(herb.type()).add(herb);
        }
       
        return herbsByType;
    }
}
