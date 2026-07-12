/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private static Integer smallest(final TreeNode current, final int target, final AtomicInteger index) {
        if (current == null) {
            return null;
        }
        final Integer result = smallest(current.left, target, index);
        if (result != null) {
            return result;
        }
        if (index.incrementAndGet() == target) {
            return current.val;
        }
        return smallest(current.right, target, index);
    }

    public int kthSmallest(final TreeNode root, final int k) {
        return smallest(root, k, new AtomicInteger());
    }
}
