class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> nodeMap = new HashMap<>();

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);

        remove(node);
        addToTail(node);

        return node.val;
    }

    public void put(int key, int value) {

        // Key already exists
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);

            node.val = value;

            remove(node);
            addToTail(node);

            return;
        }

        // Cache is full
        if (nodeMap.size() == capacity) {
            Node nodeToRemove = head.next;

            remove(nodeToRemove);
            nodeMap.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        addToTail(newNode);
        nodeMap.put(key, newNode);
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToTail(Node node) {
        Node prev = tail.pre;

        prev.next = node;
        node.pre = prev;

        node.next = tail;
        tail.pre = node;
    }
}