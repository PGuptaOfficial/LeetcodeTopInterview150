package array_string;

/**

 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".



 Example 1:

 Input: strs = ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.


 Constraints:

 1 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] consists of only lowercase English letters if it is non-empty.

 */
public class Easy14LongestCommonPrefix {
    // 1 brute force
    class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            String result = strs[0];
            String current;
            int j;

            for (int i=1; i<strs.length; i++) {
                current = strs[i];
                if (result.length() == 0 || current.length() == 0) {
                    return "";
                }

                for (j=0; j<result.length() && j<current.length(); j++){
                    if (result.charAt(j) != current.charAt(j)) {
                        break;
                    }
                }

                result = current.substring(0, j);

            }

            return result;
        }
    }

    // 2 vertical scanning
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            // vertical scanning
            char c;
            for (int i = 0; i < strs[0].length(); i++) {
                c = strs[0].charAt(i);

                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }

            return strs[0];
        }
    }
}
