package com.assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSorterTest {

    @Test
    void sortsRandomArray() {
        int[] arr = TestUtils.randomArray(100);
        int[] expected = arr.clone();
        Arrays.sort(expected);

        MergeSorter.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void sortsAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void sortsReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void sortsArrayWithDuplicates() {
        int[] arr = {3, 1, 3, 2, 1, 3};
        MergeSorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 3}, arr);
    }

    @Test
    void sortsEmptyArray() {
        int[] arr = {};
        MergeSorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void sortsSingleElementArray() {
        int[] arr = {42};
        MergeSorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }
}