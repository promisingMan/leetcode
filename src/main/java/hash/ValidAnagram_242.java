package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zengjia
 * @date 2021-07-15 21:30:14
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
//        for (int i = 0; i < sChars.length; i++) {
//            if (sChars[i] != tChars[i]) {
//                return false;
//            }
//        }
//        return true;
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagramHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) - 1);
            if (map.get(letter) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramArr(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
