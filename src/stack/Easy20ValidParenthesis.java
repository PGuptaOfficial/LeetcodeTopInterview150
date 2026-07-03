package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.


 Example 1:

 Input: s = "()"

 Output: true

 Example 2:

 Input: s = "()[]{}"

 Output: true

 Example 3:

 Input: s = "(]"

 Output: false

 Example 4:

 Input: s = "([])"

 Output: true

 Example 5:

 Input: s = "([)]"

 Output: false



 Constraints:

 1 <= s.length <= 104
 s consists of parentheses only '()[]{}'.

 */
public class Easy20ValidParenthesis {
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = Map.of(
                    ')' , '(',
                    '}' , '{',
                    ']' , '['
            );
            Deque<Character> deque = new ArrayDeque<>();
            char[] chars = s.toCharArray();

            for (char c : chars) {
                if (map.containsKey(c)) {
                    if (deque.isEmpty() || !(deque.pop().equals(map.get(c)))) {
                        return false;
                    }

                } else {
                    deque.push(c);
                }
            }

            return deque.isEmpty();
        }
    }
}
