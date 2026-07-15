/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        dfs(node);
        return nodeMap.get(node);
    }

    public Node dfs(Node node){
        if(node == null){
            return null;
        }
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }
        Node copy = new Node(node.val);
        nodeMap.put(node,copy);
        List<Node> childs = new ArrayList<>();
        for(Node child : node.neighbors){
            childs.add(dfs(child));
        }
        copy.neighbors = childs;
        return copy;
    }
}