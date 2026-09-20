package com.assignment1;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairSolver {

    public static int comparisons = 0;
    public static int maxDepth = 0;
    private static int depth = 0;

    public static double closestPair(Point[] points) {
        comparisons = 0;
        maxDepth = 0;
        depth = 0;
        Point[] byX = points.clone();
        Arrays.sort(byX, Comparator.comparingDouble(p -> p.x));
        return closestPair(byX, 0, byX.length - 1);
    }

    private static double closestPair(Point[] byX, int lo, int hi) {
        depth++;
        maxDepth = Math.max(maxDepth, depth);

        int n = hi - lo + 1;

        if (n <= 3) {
            double result = bruteForce(byX, lo, hi);
            depth--;
            return result;
        }

        int mid = lo + (hi - lo) / 2;
        double midX = byX[mid].x;

        double leftMin = closestPair(byX, lo, mid);
        double rightMin = closestPair(byX, mid + 1, hi);
        double min = Math.min(leftMin, rightMin);

        Point[] strip = new Point[n];
        int stripSize = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(byX[i].x - midX) < min) {
                strip[stripSize++] = byX[i];
            }
        }

        Arrays.sort(strip, 0, stripSize, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < min; j++) {
                comparisons++;
                min = Math.min(min, strip[i].distanceTo(strip[j]));
            }
        }

        depth--;
        return min;
    }

    public static double bruteForce(Point[] points, int lo, int hi) {
        double min = Double.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                comparisons++;
                min = Math.min(min, points[i].distanceTo(points[j]));
            }
        }
        return min;
    }
}