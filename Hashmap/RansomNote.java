package Hashmap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']++;
            // 'a' = 97 in ASCII
            // lowercase ASCII range = (97 - 122) = (a - z)
            // this creates zero-based indexing
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        String ransomNote = "aabb";
        String magazine = "aabbb";
        System.out.println(rn.canConstruct(ransomNote, magazine));
    }
}
