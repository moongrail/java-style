package org.example.strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {
        String line = "may";

        System.out.println(isUniqueCharactersSet(line));
        System.out.println(isUniqueCharacters(line));
    }

    private static boolean isUniqueCharactersSet(String line) {
        if (Objects.nonNull(line) && !line.isBlank()) {
            String lowerCaseLine = line.toLowerCase();
            Set<Character> lineSet = new HashSet<>();

            for (int i = 0; i < lowerCaseLine.length(); i++) {
                lineSet.add(lowerCaseLine.charAt(i));
            }

            return lineSet.size() == line.length();
        }

        return false;
    }

    private static boolean isUniqueCharacters(String line){
        if (Objects.nonNull(line) && !line.isBlank()) {
            String lowerCaseLine = line.toLowerCase();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < lowerCaseLine.length(); i++) {
                char c = lowerCaseLine.charAt(i);
                if (!sb.toString().contains(String.valueOf(c))){
                    sb.append(c);
                }
            }
            return sb.length() == lowerCaseLine.length();
        }

        return false;
    }
}
