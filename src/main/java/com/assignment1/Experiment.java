package com.assignment1;

import java.util.Arrays;
import java.util.Random;

    public class Experiment {
        private static final Random RANDOM = new Random();

        public static int[] randomArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = RANDOM.nextInt(n * 10);
            return arr;
        }

        public static int[] sortedArray(int n) {
            int[] arr = randomArray(n);
            Arrays.sort(arr);
            return arr;
        }

        public static int[] reverseSortedArray(int n) {
            int[] arr = sortedArray(n);
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return arr;
        }

        public static int[] duplicateHeavyArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = RANDOM.nextInt(5); // only 5 distinct values
            return arr;
        }
    }

