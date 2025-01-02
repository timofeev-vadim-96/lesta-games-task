package org.example.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Быстрая сортировка")
class QuickSortTest {
    private QuickSort quickSort;

    @BeforeEach
    public void init() {
        quickSort = new QuickSort();
    }

    @Test
    public void sort() {
        int[] arr = createArray(10, 1, 100);
        quickSort.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i] >= arr[i - 1]);
        }
    }

    private static int [] createArray(int size, int leftBoarder, int rightBoarder){
        Random random = new Random();
        int [] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt(leftBoarder, rightBoarder+1);
        }
        return newArray;
    }
}