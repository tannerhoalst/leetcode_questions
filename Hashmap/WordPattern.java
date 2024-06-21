package Hashmap;

import java.util.HashMap;

public class WordPattern {
        public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char charPattern = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(charPattern)) {
                if (!charToWord.get(charPattern).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(charPattern, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != charPattern) {
                    return false;
                }
            } else {
                wordToChar.put(word, charPattern);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern pm = new WordPattern();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(pm.wordPattern(pattern, s)); // Output: true

        pattern = "abba";
        s = "dog cat cat fish";
        System.out.println(pm.wordPattern(pattern, s)); // Output: false

        pattern = "aaaa";
        s = "dog cat cat dog";
        System.out.println(pm.wordPattern(pattern, s)); // Output: false

        pattern = "abba";
        s = "dog dog dog dog";
        System.out.println(pm.wordPattern(pattern, s)); // Output: false
    }
}
