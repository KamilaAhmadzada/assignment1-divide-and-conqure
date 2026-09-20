package com.assignment1;

import java.util.Random;

public class TestUtils {
    private static final Random RANDOM = new Random();

    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = RANDOM.nextInt(n * 10);
        return arr;
    }
}
