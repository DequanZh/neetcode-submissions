/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while(a != b){
            a = a.parent;
            b = b.parent;
            if(b == null){
                b = p;
            }
            if(a == null){
                a = q;
            }
        }
        return a;
    }
}