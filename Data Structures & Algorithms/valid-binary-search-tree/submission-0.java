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
    private static boolean validate(final TreeNode node, final Integer min, final Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && max <= node.val)) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public boolean isValidBST(final TreeNode root) {
        return validate(root, null, null);
    }
}
