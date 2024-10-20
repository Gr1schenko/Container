package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс, описывающий контейнер
 * @param <T> тип элементов в контейнере
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 * @see Node
 */

public class MyList <T> {
    /**
     * Поле начало контейнера
     */
    private Node<T> head;

    /**
     * Поле размер контейнера
     */
    private int size;

    /**
     * Конструктор пустого контейнера
     */
    public MyList() {
        head = null;
        size = 0;
    }

    /**
     * Метод получения размера контейнера
     * @return размер контейнера
     */
    public int getSize() {
        return size;
    }

    /**
     * Метод получения значения элемента контейнера по заданному индексу
     * @param index индекс элемента
     * @return значение элемента заданного индекса
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Метод добавления элемента в конец контейнера
     * @param data значение, которое нужно добавить в контейнер
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null value to the list");
        }
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    /**
     * Метод удаления элемента из контейнера по заданному индексу
     * @param index индекс элемента
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    /**
     * Метод вывода контейнера на экран пользователя
     */
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Итератор для перебора элементов списка, поддерживающий
     * стандартные операции итерации, такие как hasNext() и next()
     * @return объект, позволяющий осуществлять перебор элементов списка
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = current.data;
                current = current.next;
                return result;
            }
        };
    }
}
