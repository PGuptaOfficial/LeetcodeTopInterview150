package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the
 original letters exactly once.

 Example 1:

 Input: s = "anagram", t = "nagaram"

 Output: true

 Example 2:

 Input: s = "rat", t = "car"

 Output: false



 Constraints:

 1 <= s.length, t.length <= 5 * 104
 s and t consist of lowercase English letters.

 */
public class Easy242ValidAnagram {
    // 1
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(tArr);

            return Arrays.equals(sArr, tArr);

        }
    }

    // 2 better for interview
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            char[] sArr = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();

            for (char c : sArr) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            char[] tArr = t.toCharArray();
            Integer count;

            for (char c : tArr) {
                count = map.get(c);

                if (count == null) return false;

                if(count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }

            return true;

        }
    }

    // 3
    class Solution3 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            }

            for (int count : map.values()) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
