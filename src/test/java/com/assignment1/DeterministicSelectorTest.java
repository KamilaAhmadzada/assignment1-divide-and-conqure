package com.assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectorTest {

    @Test
    void matchesSortedArrayAcrossManyRandomTrials() {
        for (int trial = 0; trial < 100; trial++) {
            int[] arr = TestUtils.randomArray(50);
            int k = arr.length / 2;

            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            int expected = sorted[k];

            int actual = DeterministicSelector.select(arr.clone(), k);

            assertEquals(expected, actual);
        }
    }
}