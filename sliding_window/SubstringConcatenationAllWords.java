import java.util.*;
public class SubstringConcatenationAllWords{
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();//all words are same length
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        // Sliding window
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String substring = s.substring(i, i + totalLength);
            if (isConcatenatedString(substring, wordLength, wordCount, wordMap)) {
                result.add(i);
            }
        }
        
        return result;
    }

    private boolean isConcatenatedString(String s, int wordLength, int wordCount, Map<String, Integer> wordMap) {
        Map<String, Integer> seenMap = new HashMap<>();
        for (int j = 0; j < wordCount; j++) {
            int wordStart = j * wordLength;
            String word = s.substring(wordStart, wordStart + wordLength);
            if (!wordMap.containsKey(word)) {
                return false;
            }
            seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);
            if (seenMap.get(word) > wordMap.get(word)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SubstringConcatenationAllWords sol = new SubstringConcatenationAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(sol.findSubstring(s, words)); // Output: [0, 9]
    }
}