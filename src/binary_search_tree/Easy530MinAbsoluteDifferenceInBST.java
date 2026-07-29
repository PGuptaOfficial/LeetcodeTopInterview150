package binary_search_tree;

import common.TreeNode;

/**
 Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.



 Example 1:


 Input: root = [4,2,6,1,3]
 Output: 1
 Example 2:


 Input: root = [1,0,48,null,null,12,49]
 Output: 1


 Constraints:

 The number of nodes in the tree is in the range [2, 104].
 0 <= Node.val <= 105


 Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class Easy530MinAbsoluteDifferenceInBST {

    // Binary Search Tree is a sorted tree. Traverse it using in-order traversal to get sorted values
    class Solution {

        private int min = Integer.MAX_VALUE;
        private Integer prev = null;

        public int getMinimumDifference(TreeNode root) {

            inOrderTraverse(root);
            return min;

        }

        public void inOrderTraverse(TreeNode root) {
            if (root == null) return;

            inOrderTraverse(root.left);

            if (prev != null) {
                min = Math.min(min, root.val - prev);
            }

            prev = root.val;

            inOrderTraverse(root.right);

        }
    }
}
