package org.example;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyListTest {

    @org.junit.Test
    public void TestAddInteger() {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i*10);
        }
        assertEquals(0, (int) list.get(0));
        assertEquals(10, (int) list.get(1));
        assertEquals(20, (int) list.get(2));
        assertEquals(30, (int) list.get(3));
        assertEquals(40, (int) list.get(4));
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @org.junit.Test
    public void TestAddString() {
        MyList<String> list = new MyList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("");
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
        assertEquals("!", list.get(2));
        assertEquals("", list.get(3));
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @org.junit.Test
    public void TestAddBoolean() {
        MyList<Boolean> list = new MyList<>();
        list.add(true);
        list.add(false);
        list.add(true);
        assertEquals(true, list.get(0));
        assertEquals(false, list.get(1));
        assertEquals(true, list.get(2));
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @org.junit.Test
    public void TestRemoveInteger() {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i*10);
        }
        assertEquals(3, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertEquals(10, (int) list.get(1));
        list.remove(1);
        assertEquals(2, list.getSize());
        assertEquals(20, (int) list.get(1));
        list.remove(1);
        assertEquals(1, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertEquals(0, (int) list.get(0));
        list.remove(0);
        assertEquals(0, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @org.junit.Test
    public void TestRemoveString() {
        MyList<String> list = new MyList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        assertEquals(3, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertEquals("World", list.get(1));
        list.remove(1);
        assertEquals(2, list.getSize());
        assertEquals("!", list.get(1));
        list.remove(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        list.remove(0);
        assertEquals(0, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @org.junit.Test
    public void TestRemoveBoolean() {
        MyList<Boolean> list = new MyList<>();
        list.add(false);
        list.add(true);
        list.add(false);
        assertEquals(3, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertEquals(true, list.get(1));
        list.remove(1);
        assertEquals(2, list.getSize());
        assertEquals(false, list.get(1));
        list.remove(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        list.remove(0);
        assertEquals(0, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @org.junit.Test
    public void TestGet() {
        MyList<Integer> list = new MyList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(10);
        assertEquals(10, (int) list.get(0));
        list.add(20);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertEquals(20, (int) list.get(1));
        list.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        list.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @org.junit.Test
    public void TestGetSize() {
        MyList<Integer> list = new MyList<>();
        assertEquals(0, list.getSize());
        list.add(10);
        assertEquals(1, list.getSize());
        list.add(20);
        assertEquals(2, list.getSize());
        list.remove(0);
        assertEquals(1, list.getSize());
        list.remove(0);
        assertEquals(0, list.getSize());
    }

    @org.junit.Test
    public void testIterator() {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i*10);
        }
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(10, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }
}