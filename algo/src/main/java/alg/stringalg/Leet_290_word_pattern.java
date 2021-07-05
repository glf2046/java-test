package alg.stringalg;

import java.util.HashMap;

/*
Given a pattern and a string str, find if str follows the same pattern.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.

Notes: patterncontains only lowercase alphabetical letters, and str contains words separated by a single space.
 Each word in str contains only lowercase alphabetical letters. Both pattern and str do not have leading or trailing spaces.
 Each letter in pattern must map to a word with length that is at least 1.
 */

/**
 * 290. word patten(×Ö·û´®Ä£Ê½£©
 */
public class Leet_290_word_pattern {
    public static void main(String[] args) {
        String[] s1 = {"a", "b", "b", "a"};
        String[] s2 = {"dog", "cat", "cat", "dog"};
        String[] s3 = {"dog", "cat", "dog", "dog"};
        System.out.println(patternMatches(s1, s2));
        System.out.println(patternMatches(s1, s3));

    }

    public static boolean patternMatches(String[] s1, String[] s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length != s2.length) {
            return false;
        }

        HashMap<String, String> pairedElements = new HashMap<>();

        for (int i = 0; i < s1.length; i++) {
            if (!pairedElements.containsKey(s1[i])) {
                pairedElements.put(s1[i], s2[i]);
            } else {
                if (!pairedElements.get(s1[i]).equalsIgnoreCase(s2[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
