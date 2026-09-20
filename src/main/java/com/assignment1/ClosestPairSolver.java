package com.assignment1;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairSolver {

    public static double closestPair(Point[] points) {
        Point[] byX = points.clone();
        Arrays.sort(byX, Comparator.comparingDouble(p -> p.x));
        return closestPair(byX, 0, byX.length - 1);
    }

    private static double closestPair(Point[] byX, int lo, int hi) {
        int n = hi - lo + 1;

        if (n <= 3) {
            return bruteForce(byX, lo, hi);
        }

        int mid = lo + (hi - lo) / 2;
        double midX = byX[mid].x;

        double leftMin = closestPair(byX, lo, mid);
        double rightMin = closestPair(byX, mid + 1, hi);
        double min = Math.min(leftMin, rightMin);

        // collect points within 'min' distance of the dividing line
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
                min = Math.min(min, strip[i].distanceTo(strip[j]));
            }
        }

        return min;
    }

    private static double bruteForce(Point[] points, int lo, int hi) {
        double min = Double.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                min = Math.min(min, points[i].distanceTo(points[j]));
            }
        }
        return min;
    }
}