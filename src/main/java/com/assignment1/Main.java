package com.assignment1;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 1, 5, 2, 7, 4, 6, 0};
        Point[] pts = {
                new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };

        System.out.println("Before: " + java.util.Arrays.toString(arr));
        QuickSorter.sort(arr);
        System.out.println("After:  " + java.util.Arrays.toString(arr));
        System.out.println("selected:" + DeterministicSelector.select(arr, 4));
        System.out.println("selected k=0: " + DeterministicSelector.select(arr.clone(), 0));
        System.out.println("selected k=9: " + DeterministicSelector.select(arr.clone(), 9));
        System.out.println("closest pair distance:" + ClosestPairSolver.closestPair(pts));

        System.out.println("random:      " + java.util.Arrays.toString(Experiment.randomArray(10)));
        System.out.println("sorted:      " + java.util.Arrays.toString(Experiment.sortedArray(10)));
        System.out.println("reverse:     " + java.util.Arrays.toString(Experiment.reverseSortedArray(10)));
        System.out.println("duplicates:  " + java.util.Arrays.toString(Experiment.duplicateHeavyArray(10)));

        int[] mergeSortTest = Experiment.randomArray(20);
        MergeSorter.sort(mergeSortTest);
        System.out.println("mergeSorted: " + java.util.Arrays.toString(mergeSortTest));
        System.out.println("mergeSort maxDepth: " + MergeSorter.maxDepth);
        System.out.println("mergeSort comparisons: " + MergeSorter.comparisons);
    }
}