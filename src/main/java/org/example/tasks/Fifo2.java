package org.example.tasks;

import java.util.NoSuchElementException;

/**
 * FIFO контейнер на базе массива
 */
public class Fifo2<T> {
    private static final int ARR_INIT_SIZE = 16;

    private Object[] arr;

    private int size;

    public Fifo2() {
        arr = new Object[ARR_INIT_SIZE];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T t) {
        arr[size++] = t;
        if (size == arr.length) {
            increaseSize();
        }
    }

    /**
     * @return без удаления элемент из начала очереди. Если очередь пуста, возвращает null
     */
    public T peek() {
        if (size == 0) {
            return null;
        }

        return (T) arr[0];
    }

    /**
     * @return с удалением элемент из начала очереди. Если очередь пуста, возвращает null
     */
    public T poll() {
        if (size == 0) {
            return null;
        }

        return getFirstElement();
    }

    /**
     * @return с удалением элемент из начала очереди.
     * @throws NoSuchElementException, если очередь пуста
     */
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty");
        }

        return getFirstElement();
    }

    private void increaseSize() {
        int newArrSize;
        if (size == Integer.MAX_VALUE) {
            throw new RuntimeException("The array is overflowing");
        } else if (size >= Integer.MAX_VALUE / 2) {
            newArrSize = Integer.MAX_VALUE;
        } else {
            newArrSize = size * 2;
        }

        Object[] newArray = new Object[newArrSize];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        arr = newArray;
    }

    private void decreaseSize() {
        Object[] newArray = new Object[size / 2];
        System.arraycopy(arr, 1, newArray, 0, --size);
        arr = newArray;
    }

    private T getFirstElement() {
        T element = (T) arr[0];
        if (arr.length > size * 2 && size >= ARR_INIT_SIZE) {
            decreaseSize();
        } else {
            System.arraycopy(arr, 1, arr, 0, --size);
        }

        return element;
    }
}
