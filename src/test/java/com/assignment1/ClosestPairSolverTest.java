package com.assignment1;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestPairSolverTest {

    private static final Random RANDOM = new Random();

    @Test
    void matchesBruteForceOnManyRandomTrials() {
        for (int trial = 0; trial < 50; trial++) {
            int n = 10 + RANDOM.nextInt(190); // sizes between 10 and 200
            Point[] pts = randomPoints(n);

            double expected = ClosestPairSolver.bruteForce(pts, 0, pts.length - 1);
            double actual = ClosestPairSolver.closestPair(pts);

            assertEquals(expected, actual, 1e-9);
        }
    }

    @Test
    void handlesThreePoints() {
        Point[] pts = {
                new Point(0, 0), new Point(3, 4), new Point(1, 1)
        };
        double expected = ClosestPairSolver.bruteForce(pts, 0, pts.length - 1);
        double actual = ClosestPairSolver.closestPair(pts);
        assertEquals(expected, actual, 1e-9);
    }

    private Point[] randomPoints(int n) {
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new Point(RANDOM.nextInt(1000), RANDOM.nextInt(1000));
        }
        return pts;
    }
}