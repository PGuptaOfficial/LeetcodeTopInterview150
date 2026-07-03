package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings s and t are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



 Example 1:

 Input: s = "egg", t = "add"

 Output: true

 Explanation:

 The strings s and t can be made identical by:

 Mapping 'e' to 'a'.
 Mapping 'g' to 'd'.
 Example 2:

 Input: s = "f11", t = "b23"

 Output: false

 Explanation:

 The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

 Example 3:

 Input: s = "paper", t = "title"

 Output: true



 Constraints:

 1 <= s.length <= 5 * 104
 t.length == s.length
 s and t consist of any valid ascii character.
 */
public class Easy205IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> sMap = new HashMap<>();
            Map<Character, Character> tMap = new HashMap<>();

            char sChar;
            char tChar;

            for (int i=0; i<s.length(); i++) {
                sChar = s.charAt(i);
                tChar = t.charAt(i);

                if (sMap.containsKey(sChar) || tMap.containsKey(tChar)) {
                    if (!Objects.equals(sMap.get(sChar), tChar) ||
                            !Objects.equals(tMap.get(tChar), sChar)) {
                        return false;
                    }
                } else {
                    sMap.put(sChar, tChar);
                    tMap.put(tChar, sChar);
                }
            }

            return true;

        }
    }
}
