package com.assignment1;

public class MergeSorter {
    private static final int CUTOFF = 12;

    public static int comparisons = 0;
    public static int maxDepth = 0;
    private static int depth = 0;

    public static void sort(int[] arr) {
        comparisons = 0;
        maxDepth = 0;
        depth = 0;
        int[] buffer = new int[arr.length];
        sort(arr, buffer, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] buffer, int lo, int hi) {
        depth++;
        maxDepth = Math.max(maxDepth, depth);

        if (hi - lo < CUTOFF) {
            insertionSort(arr, lo, hi);
            depth--;
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, buffer, lo, mid);
        sort(arr, buffer, mid + 1, hi);
        merge(arr, buffer, lo, mid, hi);

        depth--;
    }

    private static void merge(int[] arr, int[] buffer, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            buffer[i] = arr[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = buffer[j++];
            } else if (j > hi) {
                arr[k] = buffer[i++];
            } else {
                comparisons++;
                if (buffer[j] < buffer[i]) {
                    arr[k] = buffer[j++];
                } else {
                    arr[k] = buffer[i++];
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo) {
                comparisons++;
                if (arr[j] <= key) break;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}