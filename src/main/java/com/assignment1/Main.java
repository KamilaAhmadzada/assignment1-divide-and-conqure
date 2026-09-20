package com.assignment1;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 1, 5, 2, 7, 4, 6, 0};

        System.out.println("Before: " + java.util.Arrays.toString(arr));
        QuickSorter.sort(arr);
        System.out.println("After:  " + java.util.Arrays.toString(arr));
        System.out.println("selected:" + DeterministicSelector.select(arr, 4));
    }
}
