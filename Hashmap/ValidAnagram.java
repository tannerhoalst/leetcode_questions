package Hashmap;

import java.util.HashMap;

public class ValidAnagram {
        public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c);
            }
        }

        return charCountMap.isEmpty();
    }

    public static void main(String[] args) {
        ValidAnagram checker = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(checker.isAnagram(s, t)); // Output: true

        s = "rat";
        t = "car";
        System.out.println(checker.isAnagram(s, t)); // Output: false
    }
}
