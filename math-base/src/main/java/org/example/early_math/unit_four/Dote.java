package org.example.early_math.unit_four;

import java.util.HashSet;

public class Dote {

    public static void main(String[] args) {
        int[][] points = {{1, 2}, {-1, 2}, {3, 4}, {-3, 4}, {-4, 4}};

        System.out.println("Points with mirror symmetry:");
        for (int[] point : points) {
            int mirrorX = -point[0];
            int[] mirrorPoint = {mirrorX, point[1]};
            if (containsPoint(points, mirrorPoint)) {
                System.out.println("(" + point[0] + ", " + point[1] + ")");
            }
        }
    }

    private static boolean containsPoint(int[][] points, int[] targetPoint) {
        for (int[] point : points) {
            if (point[0] == targetPoint[0] && point[1] == targetPoint[1]) {
                return true;
            }
        }
        return false;
    }
}
