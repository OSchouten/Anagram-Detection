/**
 * @author Olivier Schouten
 */

package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = new LinkedList<>(Arrays.asList("rope", "pore", "repo", "red rum", "murder", "listen", "silent", "endeavour"));

        List<List<String>> anagrams = new ArrayList<>();
        for (int i = words.size() - 1; i >= 0; i--) {
            String s1 = words.get(i);
            List<String> matches = new ArrayList<>();
            matches.add(s1);
            words.remove(s1); // Ensure that word is only checked once

            for (int j = words.size() - 1; j >= 0; j--) {
                String s2 = words.get(j);

                if (isAnagram(s1, s2)) {
                    matches.add(s2);

                    // Remove word from words list and decrement i from initial loop to avoid index out of bounds.
                    words.remove(s2);
                    i--;
                }
            }

            // Reversing to match example output but not necessary
            Collections.reverse(matches);
            anagrams.add(matches);
        }

        // Reversing to match example output but not necessary
        Collections.reverse(anagrams);
        System.out.println(anagrams);
    }

    /**
     * Compares two inputs to see if they are anagrams of each other.
     * @param input1 Input string 1.
     * @param input2 Input string 2.
     * @return Return a true or false.
     */
    static boolean isAnagram(String input1, String input2) {
        // Get rid of white spaces and non visible characters in both strings
        String string1 = input1.replaceAll("\\s+", "");
        String string2 = input2.replaceAll("\\s+", "");

        // Anagrams must be the same length
        if (string1.length() != string2.length())
            return false;

        // Convert strings to lower case before converting to char arrays
        char[] char1 = string1.toLowerCase().toCharArray();
        char[] char2 = string2.toLowerCase().toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        return Arrays.equals(char1, char2);
    }
}
