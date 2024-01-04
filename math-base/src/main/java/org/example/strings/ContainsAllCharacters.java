package org.example.strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ContainsAllCharacters {
    public static void main(String[] args) {
        String firstLine = "first";
        String secondLine = "frtis";

        System.out.println(isContainsAllCharacters(firstLine, secondLine));
    }

    private static boolean isContainsAllCharacters(String firstLine, String secondLine) {
        if (Objects.isNull(firstLine) || Objects.isNull(secondLine)) return false;
        if (firstLine.length() != secondLine.length()) return false;

        Set<Character> lineSet = new HashSet<>();

        for (int i = 0; i < firstLine.length(); i++) {
            lineSet.add(firstLine.charAt(i));
        }

        int sizeAfterFirst = lineSet.size();

        for (int i = 0; i < secondLine.length(); i++) {
            lineSet.add(firstLine.charAt(i));
        }

        return sizeAfterFirst == lineSet.size();
    }
}
