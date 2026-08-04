package array_string;

/**
 Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



 Example 1:

 Input: nums = [1,2,3,4,5,6,7], k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: nums = [-1,-100,3,99], k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]


 Constraints:

 1 <= nums.length <= 105
 -231 <= nums[i] <= 231 - 1
 0 <= k <= 105

 */
public class Med189RotateArray {

    // Sol-1 : Extra array
    class Solution1 {
        public void rotate(int[] nums, int k) {
            int len = nums.length;

            // Since rotating an array by its length 'len' returns it to the original state, any extra full rotations
            // are redundant. Therefore, we reduce k using k %= len, which gives the effective number of rotations.
            k %= len;

            if (k==0 || len==1) {
                return;
            }

            int[] temp = new int[len];

            for (int i=0; i<len; i++) {
                temp[(i+k) % len] = nums[i];
            }

            for (int i=0; i<len; i++) {
                nums[i] = temp[i];
            }

        }
    }

    // Reverse Algorithm (Best solution)
    class Solution2 {
        public void rotate(int[] nums, int k) {
            int len = nums.length;

            k %= len;
            if (k==0 || len==1) {
                return;
            }

            reverse(nums, 0, len-1); // reverse whole array
            reverse(nums, 0, k - 1); // reverse first k elements
            reverse(nums, k, len - 1); // reverse remaining

        }

        private void reverse(int[] nums, int left, int right) {
            int temp;

            while(left < right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

    }

}
