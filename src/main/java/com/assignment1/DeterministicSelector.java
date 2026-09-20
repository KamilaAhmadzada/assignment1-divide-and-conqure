package com.assignment1;

public class DeterministicSelector {

    public static int comparisons = 0;
    public static int maxDepth = 0;
    private static int depth = 0;

    public static int select(int[] arr, int k) {
        comparisons = 0;
        maxDepth = 0;
        depth = 0;
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int lo, int hi, int k) {
        depth++;
        maxDepth = Math.max(maxDepth, depth);

        if (lo == hi) {
            depth--;
            return arr[lo];
        }

        int pivotIndex = medianOfMedians(arr, lo, hi);
        pivotIndex = partition(arr, lo, hi, pivotIndex);

        int result;
        if (k == pivotIndex) {
            result = arr[k];
        } else if (k < pivotIndex) {
            result = select(arr, lo, pivotIndex - 1, k);
        } else {
            result = select(arr, pivotIndex + 1, hi, k);
        }

        depth--;
        return result;
    }

    private static int medianOfMedians(int[] arr, int lo, int hi) {
        int n = hi - lo + 1;

        if (n <= 5) {
            insertionSort(arr, lo, hi);
            return lo + n / 2;
        }

        int groups = (n + 4) / 5;
        for (int i = 0; i < groups; i++) {
            int groupLo = lo + i * 5;
            int groupHi = Math.min(groupLo + 4, hi);
            insertionSort(arr, groupLo, groupHi);
            swap(arr, lo + i, groupLo + (groupHi - groupLo) / 2);
        }

        int mid = lo + (groups - 1) / 2;
        select(arr, lo, lo + groups - 1, mid);
        return mid;
    }

    private static int partition(int[] arr, int lo, int hi, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, hi);

        int store = lo;
        for (int i = lo; i < hi; i++) {
            comparisons++;
            if (arr[i] < pivot) {
                swap(arr, store, i);
                store++;
            }
        }
        swap(arr, store, hi);
        return store;
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

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}