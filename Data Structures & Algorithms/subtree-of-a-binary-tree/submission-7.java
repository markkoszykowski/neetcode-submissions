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
    private boolean subtree(final TreeNode node, final TreeNode current, final boolean head) {
        if (node == null) {
            return current == null;
        }
        if (current == null) {
            return false;
        }
        if (current.val == node.val && (subtree(node.left, current.left, false) && subtree(node.right, current.right, false))) {
            return true;
        }
        return head && (subtree(node.left, current, true) || subtree(node.right, current, true));
    }

    public boolean isSubtree(final TreeNode root, final TreeNode subRoot) {
        return subtree(root, subRoot, true);
    }
}
