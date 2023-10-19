package org.example.early_math.unit_four;

import java.math.BigInteger;

public class Nod {
    public static void main(String[] args) {
        System.out.println(findGcdRecursive(1680, 640));
    }

    private static int findGcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }

    private static int findGcdRecursive(int a, int b) {
        if (b == 0) return a;
        return findGcdRecursive(b, a % b);
    }
}
