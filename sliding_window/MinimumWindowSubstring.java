import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
        public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0;
        int matched = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charMap.containsKey(rightChar)) {
                windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
                if (windowMap.get(rightChar).intValue() == charMap.get(rightChar).intValue()) {
                    matched++;
                }
            }

            while (matched == charMap.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (charMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).intValue() == charMap.get(leftChar).intValue()) {
                        matched--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start + minLength);
        }
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(sol.minWindow(s, t)); // Output: "BANC"
    }
}
