package org.example;

/**
 * Класс, описывающий простой список
 * @param <T> тип элементов в списке
 * @author Yuliya Grischenko <Yuliya-280504@mail.ru>
 * @version 1.0-SNAPSHOT
 * @see MyList
 */

public class Node<T> {
    /**
     * Поле значение элемента списка
     */
    public T data;
    /**
     * Поле ссылка на следующий элемент списка
     */
    public Node<T> next;

    /**
     * Конструктор создания узла с заданным значением
     * @param data значение узла
     */
    public Node(T data){
        this.data = data;
        this.next = null;
    }

    /**
     * Метод получения значения элемента списка
     * @return значение узла
     */
    public T getData() {
        return data;
    }

    /**
     * Метод получения ссылки на следующий элемент списка
     * @return ссылка на следующий узел
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Метод добавления следующего элемента списка
     * @param next следующий узел
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
