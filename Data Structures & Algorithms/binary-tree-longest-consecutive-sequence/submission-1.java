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
    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null);
        return maxLength;
    }

    public int dfs(TreeNode root, TreeNode parent){
        if(root == null){
            return 0;
        }
        if(parent != null){
            if(root.val - parent.val > 1 || root.val <= parent.val)
                return Math.max(dfs(root.left,root), dfs(root.right,root));
        }
        int left = dfs(root.left, root);
        int right = dfs(root.right, root);
        int curMax = 1 + Math.max(left,right);
        maxLength = Math.max(maxLength, curMax);
        return curMax;
    }
}
