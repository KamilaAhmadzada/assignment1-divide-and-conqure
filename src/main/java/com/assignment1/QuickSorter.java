package com.assignment1;

import java.util.Random;

public class QuickSorter {
    private static final Random RANDOM = new Random();

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        while (lo < hi) {
            int p = partition(arr, lo, hi);

            if (p - lo < hi - p) {
                sort(arr, lo, p - 1);
                lo = p + 1;
            } else {
                sort(arr, p + 1, hi);
                hi = p - 1;
            }
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivotIndex = lo + RANDOM.nextInt(hi - lo + 1);
        swap(arr, pivotIndex, hi);
        int pivot = arr[hi];

        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
