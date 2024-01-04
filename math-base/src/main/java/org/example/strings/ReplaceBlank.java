package org.example.strings;

public class ReplaceBlank {
    public static void main(String[] args) {
        String line = "Mr John Smith    ";

        System.out.println(replaceBlank(line));
    }

    private static String replaceBlank(String line){
        if (line == null) return "";

        String trimLine = line.trim();

        return trimLine.replaceAll(" ","%20");
    }
}
