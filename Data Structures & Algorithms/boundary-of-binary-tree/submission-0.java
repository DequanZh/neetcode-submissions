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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftResult = new ArrayList<>();
        leftResult.add(root.val);
        dfsLeft(root.left,1,leftResult);
        List<Integer> rightResult = new ArrayList<>();
        dfsRight(root.right,0,rightResult);
        Collections.reverse(rightResult);
        for(int num : rightResult){
            leftResult.add(num);
        }
        return leftResult;
    }

    public void dfsLeft(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }
        if(result.size() <= level){
            result.add(root.val);
        }
        dfsLeft(root.left, level+1, result);
        dfsLeft(root.right, level+1, result);
    }

    public void dfsRight(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }
        if(result.size() <= level){
            result.add(root.val);
        }
        dfsRight(root.right, level+1, result);
        dfsRight(root.left, level+1, result);
    }
}
