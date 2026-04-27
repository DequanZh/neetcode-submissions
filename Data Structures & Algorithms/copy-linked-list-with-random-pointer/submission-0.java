/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> copyNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(copyNode.containsKey(head)){
            return copyNode.get(head);
        }
        Node copy = new Node(head.val);
        copyNode.put(head,copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;    
    }
}
