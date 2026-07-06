package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 Write an algorithm to determine if a number n is happy.

 A happy number is a number defined by the following process:

 Starting with any positive integer, replace the number by the sum of the squares of its digits.
 Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy.
 Return true if n is a happy number, and false if not.



 Example 1:

 Input: n = 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 Example 2:

 Input: n = 2
 Output: false


 Constraints:

 1 <= n <= 231 - 1

 */
public class Easy202HappyNumber {

    // 1 - brute force
    class Solution {
        public boolean isHappy(int n) {
            int rem;

            Set<Integer> set = new HashSet<>();

            while (true) {
                rem = n;
                n = 0;
                while(rem != 0) {
                    n += (int) Math.pow((rem % 10), 2);
                    rem = rem / 10;
                }

                if (n==1) return true;

                if (set.contains(n)) return false;

                set.add(n);

            }

        }
    }

    // 2 - final - Floyd's Cycle Detection Algorithm / Tortise and Hare Algorithm
    class Solution2 {
        public boolean isHappy(int n) {

            // Floyd's Cycle Detection Algorithm / Tortise and Hare Algorithm

            int slow = n;
            int fast = n;

            while (true) {
                slow = getNext(slow);
                fast = getNext(getNext(fast));

                if (fast==1) return true;

                if (slow == fast) return false;

            }

        }

        private int getNext(int n) {
            int sum = 0;

            while(n != 0) {
                sum += (int) Math.pow((n % 10), 2);
                n = n / 10;
            }

            return sum;
        }

    }


}
