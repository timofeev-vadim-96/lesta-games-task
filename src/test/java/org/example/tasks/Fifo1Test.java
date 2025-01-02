package org.example.tasks;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("FIFO очередь через ноды")
class Fifo1Test {
    private static Fifo1<Integer> queue;

    @BeforeAll
    static void init() {
        queue = new Fifo1<>();
    }

    @Test
    @Order(5)
    void getSize() {
        assertEquals(15, queue.getSize());
    }

    @Test
    @Order(1)
    void add() {
        assertDoesNotThrow(() -> IntStream.rangeClosed(1, 17).forEach(i -> queue.add(i)));
    }

    @Test
    @Order(2)
    void peek() {
        assertEquals(1, queue.peek());
    }

    @Test
    @Order(3)
    void poll() {
        assertEquals(1, queue.poll());
    }

    @Test
    @Order(4)
    void pop() {
        assertEquals(2, queue.pop());
    }

    @Test
    @Order(6)
    void pollWhenQueueBecomesEmpty() {
        for (int i = 3; i < 18; i++) {
            assertEquals(i, queue.poll());
        }

        assertNull(queue.poll());
    }

    @Test
    @Order(7)
    void popWhenQueueIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> queue.pop());
    }
}