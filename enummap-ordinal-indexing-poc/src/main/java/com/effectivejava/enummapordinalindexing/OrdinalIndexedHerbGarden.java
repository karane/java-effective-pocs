package com.effectivejava.enummapordinalindexing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class OrdinalIndexedHerbGarden {

    @SuppressWarnings("unchecked")
    public static Set<Herb>[] groupByType(List<Herb> herbs) {
        Set<Herb>[] herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
        
        for (int i = 0; i < herbsByType.length; i++) {
            herbsByType[i] = new HashSet<>();
        }
        for (Herb herb : herbs) {
            herbsByType[herb.type().ordinal()].add(herb);
        }
        
        return herbsByType;
    }
}
