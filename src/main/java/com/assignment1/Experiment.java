package com.assignment1;

import java.util.Arrays;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        public static void main(String[] args) throws IOException {
            try (PrintWriter writer = new PrintWriter(new FileWriter("results/results.csv"))) {
                writer.println("algorithm,inputType,size,timeMs,maxDepth,comparisons");

                int[] sizes = {100, 1000, 10000};
                String[] types = {"random", "sorted", "reverse", "duplicates"};

                for (int size : sizes) {
                    for (String type : types) {
                        int[] arr = generate(type, size);

                        long start = System.nanoTime();
                        MergeSorter.sort(arr);
                        long end = System.nanoTime();
                        long timeMs = (end - start) / 1_000_000;

                        writer.println("MergeSort," + type + "," + size + "," + timeMs + "," + MergeSorter.maxDepth + "," + MergeSorter.comparisons);
                        int[] arr2 = generate(type, size);
                        long start2 = System.nanoTime();
                        QuickSorter.sort(arr2);
                        long end2 = System.nanoTime();
                        long timeMs2 = (end2 - start2) / 1_000_000;
                        writer.println("QuickSort," + type + "," + size + "," + timeMs2 + "," + QuickSorter.maxDepth + "," + QuickSorter.comparisons);
                        int[] arr3 = generate(type, size);
                        long start3 = System.nanoTime();
                        DeterministicSelector.select(arr3, size / 2);
                        long end3 = System.nanoTime();
                        long timeMs3 = (end3 - start3) / 1_000_000;
                        writer.println("DeterministicSelect," + type + "," + size + "," + timeMs3 + "," + DeterministicSelector.maxDepth + "," + DeterministicSelector.comparisons);
                    }
                }
            }
        }

        private static int[] generate(String type, int n) {
            switch (type) {
                case "sorted": return sortedArray(n);
                case "reverse": return reverseSortedArray(n);
                case "duplicates": return duplicateHeavyArray(n);
                default: return randomArray(n);
            }
        }
    }




