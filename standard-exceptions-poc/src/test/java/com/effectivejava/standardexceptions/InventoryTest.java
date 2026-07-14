package com.effectivejava.standardexceptions;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InventoryTest {

    @Test
    void constructorRejectsNegativeCapacityWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Inventory(-1));
    }

    @Test
    void setCapacityRejectsNegativeValueWithIllegalArgumentException() {
        Inventory inventory = new Inventory(2);

        assertThrows(IllegalArgumentException.class, () -> inventory.setCapacity(-5));
    }

    @Test
    void addItemRejectsNullWithNullPointerException() {
        Inventory inventory = new Inventory(2);

        assertThrows(NullPointerException.class, () -> inventory.addItem(null));
    }

    @Test
    void addItemRejectsOverflowWithIllegalStateException() {
        Inventory inventory = new Inventory(1);
        inventory.addItem("widget");

        assertThrows(IllegalStateException.class, () -> inventory.addItem("gadget"));
    }

    @Test
    void removeAtRejectsOutOfRangeIndexWithIndexOutOfBoundsException() {
        Inventory inventory = new Inventory(2);
        inventory.addItem("widget");

        assertThrows(IndexOutOfBoundsException.class, () -> inventory.removeAt(5));
        assertThrows(IndexOutOfBoundsException.class, () -> inventory.removeAt(-1));
    }

    @Test
    void removeAtReturnsTheRemovedItem() {
        Inventory inventory = new Inventory(2);
        inventory.addItem("widget");

        assertEquals("widget", inventory.removeAt(0));
        assertEquals(0, inventory.size());
    }

    @Test
    void itemsViewRejectsMutationWithUnsupportedOperationException() {
        Inventory inventory = new Inventory(2);
        inventory.addItem("widget");

        List<String> view = inventory.itemsView();

        assertThrows(UnsupportedOperationException.class, () -> view.add("gadget"));
        assertThrows(UnsupportedOperationException.class, () -> view.remove("widget"));
    }

    @Test
    void iteratingItemsViewWhileMutatingInventoryThrowsConcurrentModificationException() {
        Inventory inventory = new Inventory(3);
        inventory.addItem("widget");
        inventory.addItem("gadget");

        List<String> view = inventory.itemsView();
        Iterator<String> iterator = view.iterator();
        iterator.next();
        inventory.addItem("gizmo");

        assertThrows(ConcurrentModificationException.class, iterator::next);
    }
}
