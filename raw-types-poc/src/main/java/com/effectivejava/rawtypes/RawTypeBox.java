package com.effectivejava.rawtypes;

import java.util.ArrayList;
import java.util.List;

public final class RawTypeBox {

    private RawTypeBox() {
        throw new AssertionError();
    }

    @SuppressWarnings("rawtypes")
    public static List makeRawList() {
        List list = new ArrayList();
        list.add("hello");
        list.add(42);
        return list;
    }

    public static List<Object> makeObjectList() {
        List<Object> list = new ArrayList<>();
        list.add("hello");
        list.add(42);
        return list;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void addToRaw(List list, Object element) {
        list.add(element);
    }

    public static int countElements(List<?> list) {
        return list.size();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static String extractStringUnsafe(List rawList, int index) {
        return (String) rawList.get(index);
    }
}
