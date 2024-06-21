package Hashmap;

import java.util.HashMap;

public class IsomorphicStrings {
        public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                mapS.put(charS, charT);
            }

            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) {
                    return false; 
                }
            } else {
                mapT.put(charT, charS);
            }
        }

        return true;
    }

    //slightly faster
    public boolean isIsomorphicArray(String s, String t) {
        if (s.length() != t.length()) {
            return false; 
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256]; 
        //256 = all possible ASCII characters

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS[charS] == 0 && mapT[charT] == 0) {
                mapS[charS] = charT;
                mapT[charT] = charS;
            } else if (mapS[charS] != charT || mapT[charT] != charS) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        String s = "egg";
        String t = "add";
        System.out.println(isomorphicStrings.isIsomorphic(s, t)); 
        System.out.println(isomorphicStrings.isIsomorphicArray(s, t)); 

        s = "foo";
        t = "bar";
        System.out.println(isomorphicStrings.isIsomorphic(s, t));
        System.out.println(isomorphicStrings.isIsomorphicArray(s, t)); 

        s = "paper";
        t = "title";
        System.out.println(isomorphicStrings.isIsomorphic(s, t));
        System.out.println(isomorphicStrings.isIsomorphicArray(s, t)); 
    }

    
}
