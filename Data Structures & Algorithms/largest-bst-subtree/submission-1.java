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
    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return maxSize;
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if(root.val > left[1] && root.val < right[0]){
            int size = left[2] + right[2] + 1;
            maxSize = Math.max(maxSize, size);
            return new int[]{
                Math.min(left[0],root.val), 
                Math.max(right[1],root.val),
                size
            };
        }

        return new int[]{
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0
        };
    }
}
