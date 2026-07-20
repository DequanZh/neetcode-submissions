/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int diameter = 0;
    public int diameter(Node root) {
        dfs(root);
        return diameter;
    }

    public int dfs(Node root){
        if(root == null){
            return 0;
        }
        int firstMax = 0;
        int secondMax = 0;
        for(Node c : root.children){
            int length = dfs(c) + 1;
            if(length >= firstMax){
                secondMax = firstMax;
                firstMax = length;
            }else if(length >= secondMax){
                secondMax = length;
            }
        }
        diameter = Math.max(diameter, firstMax + secondMax);
        return firstMax;
    }
}
