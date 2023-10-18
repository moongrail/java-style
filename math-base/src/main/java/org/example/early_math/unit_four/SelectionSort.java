package org.example.early_math.unit_four;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Band[] bandArray = {new Band("First", 32),
                new Band("Second", 333),
                new Band("Third", 12),
                new Band("Fourth", 123),
                new Band("Fifth", 555)};

        System.out.println(Arrays.toString(sortDesc(bandArray)));
    }

    private static Band[] sortDesc(Band[] bands) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < bands.length - 1; i++) {
                if (bands[i].countPlay < bands[i + 1].countPlay) {
                    Band temp = bands[i + 1];
                    bands[i + 1] = bands[i];
                    bands[i] = temp;
                    isSorted = false;
                }
            }
        }

        return bands;
    }

    static class Band {
        private String name;
        private int countPlay;

        public Band(String name, int countPlay) {
            this.name = name;
            this.countPlay = countPlay;
        }

        @Override
        public String toString() {
            return "Band{" +
                    "name='" + name + '\'' +
                    ", countPlay=" + countPlay +
                    '}';
        }
    }
}
