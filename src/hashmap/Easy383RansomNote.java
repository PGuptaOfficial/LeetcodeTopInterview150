package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

 Each letter in magazine can only be used once in ransomNote.



 Example 1:

 Input: ransomNote = "a", magazine = "b"
 Output: false
 Example 2:

 Input: ransomNote = "aa", magazine = "ab"
 Output: false
 Example 3:

 Input: ransomNote = "aa", magazine = "aab"
 Output: true


 Constraints:

 1 <= ransomNote.length, magazine.length <= 105
 ransomNote and magazine consist of lowercase English letters.
 */
public class Easy383RansomNote {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            Map<Character, Integer> map = new HashMap<>();
            char[] ransomNoteChars = ransomNote.toCharArray();
            int index;

            for (char ransomNoteChar : ransomNoteChars) {
                index = magazine.indexOf(ransomNoteChar,
                        map.getOrDefault(ransomNoteChar, -1) + 1
                );
                if (index == -1) return false;

                map.put(ransomNoteChar, index);
            }

            return true;
        }
    }
}
