package com.effectivejava.standardexceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Inventory {

    private final List<String> items = new ArrayList<>();
    private int capacity;

    public Inventory(int capacity) {
        setCapacity(capacity);
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 0: " + capacity);
        }
        this.capacity = capacity;
    }

    public int capacity() {
        return capacity;
    }

    public void addItem(String item) {
        Objects.requireNonNull(item, "item must not be null");
        if (items.size() >= capacity) {
            throw new IllegalStateException("Inventory is full: capacity=" + capacity);
        }
        items.add(item);
    }

    public String removeAt(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException(
                    "index %d out of bounds for size %d".formatted(index, items.size()));
        }
        return items.remove(index);
    }

    public int size() {
        return items.size();
    }

    public List<String> itemsView() {
        return Collections.unmodifiableList(items);
    }
}
