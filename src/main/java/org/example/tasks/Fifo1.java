package org.example.tasks;

import java.util.NoSuchElementException;

/**
 * FIFO контейнер на базе ноды связного списка
 */
public class Fifo1<T> {
    private ListNode<T> head;

    private ListNode<T> tail;

    private int size;

    public Fifo1() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * Добавление
     */
    public void add(T numb) {
        if (head == null) {
            head = new ListNode<>(numb);
        } else if (tail == null ) {
            tail = new ListNode<>(numb);
            head.next = tail;
        } else {
            ListNode<T> next = new ListNode<>(numb);
            tail.next = next;
            tail = next;
        }
        size++;
    }

    /**
     * @return первый элемент без удаления из начала очереди. Если очередь пуста, возвращает null
     */
    public T peek() {
        if (head == null) {
            return null;
        }

        return head.value;
    }

    /**
     * @return первый элемент с удалением из начала очереди. Если очередь пуста, возвращает null
     */
    public T poll () {
        if (head == null) {
            return null;
        }

        T value = head.value;
        if (tail == head) {
            tail = head.next;
        }
        head = head.next;
        size--;

        return value;
    }

    /**
     * @return первый элемент с удалением из начала очереди.
     * @throws NoSuchElementException, если очередь пуста
     */
    public T pop () {
        if (head == null) {
            throw new NoSuchElementException();
        }

        T value = head.value;
        if (tail == head) {
            tail = head.next;
        }
        head = head.next;
        size--;

        return value;
    }

    private class ListNode<T> {
        private final T value;
        private ListNode<T> next;

        public ListNode(T value) {
            this.value = value;
        }

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }
    }
}
