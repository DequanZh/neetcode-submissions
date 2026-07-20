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
    double maxAverage = 0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return maxAverage;
    }

    public double[] dfs(TreeNode root){
        if(root == null){
            return null;
        }
        double[] left = dfs(root.left);
        double[] right = dfs(root.right);
        double sum = root.val * 1.0;
        double length = 1.0;
        
        if(left == null && right == null){
            maxAverage = Math.max(root.val,maxAverage);
            return new double[]{root.val,1};
        }
        if(left != null && right != null){
            sum += left[0] + right[0];
            length += left[1] + right[1];
            maxAverage = Math.max(maxAverage, sum/length);
            return new double[]{sum,length};
        }
        if(left != null){
            sum += left[0];
            length += left[1];
            maxAverage = Math.max(maxAverage, sum/length);
            return new double[]{sum,length};
        }
        sum += right[0];
        length += right[1];
        maxAverage = Math.max(maxAverage, sum/length);
        return new double[]{sum,length};
    }
}
