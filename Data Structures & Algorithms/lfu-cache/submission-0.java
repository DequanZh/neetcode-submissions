class LFUCache {

    class Node {
        int key;
        int val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleLinkedList {
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        // key -> node
        Map<Integer, Node> nodeMap = new HashMap<>();

        public DoubleLinkedList() {
            head.next = tail;
            tail.pre = head;
        }

        public int length() {
            return nodeMap.size();
        }

        public Node remove(int key) {
            Node node = nodeMap.get(key);

            node.pre.next = node.next;
            node.next.pre = node.pre;

            nodeMap.remove(key);

            return node;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }

            Node node = head.next;

            node.pre.next = node.next;
            node.next.pre = node.pre;

            nodeMap.remove(node.key);

            return node;
        }

        public void addLast(Node node) {
            Node pre = tail.pre;

            pre.next = node;
            node.pre = pre;

            node.next = tail;
            tail.pre = node;

            nodeMap.put(node.key, node);
        }
    }

    // key -> frequency
    Map<Integer, Integer> countMap = new HashMap<>();

    // frequency -> doubly linked list
    Map<Integer, DoubleLinkedList> freNodeMap = new HashMap<>();

    int capacity;
    int leastFrequenly;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.leastFrequenly = 0;
    }

    public int get(int key) {
        if (!countMap.containsKey(key)) {
            return -1;
        }

        int keyFre = countMap.get(key);

        DoubleLinkedList curList = freNodeMap.get(keyFre);
        Node curNode = curList.remove(key);

        countMap.put(key, keyFre + 1);

        DoubleLinkedList nextList =
            freNodeMap.getOrDefault(
                keyFre + 1,
                new DoubleLinkedList()
            );

        nextList.addLast(curNode);
        freNodeMap.put(keyFre + 1, nextList);

        // If the old minimum frequency list is empty,
        // move minimum frequency up.
        if (keyFre == leastFrequenly && curList.length() == 0) {
            leastFrequenly++;
        }

        return curNode.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (countMap.containsKey(key)) {
            int keyFre = countMap.get(key);

            DoubleLinkedList curList = freNodeMap.get(keyFre);
            Node curNode = curList.remove(key);

            curNode.val = value;

            countMap.put(key, keyFre + 1);

            DoubleLinkedList nextList =
                freNodeMap.getOrDefault(
                    keyFre + 1,
                    new DoubleLinkedList()
                );

            nextList.addLast(curNode);
            freNodeMap.put(keyFre + 1, nextList);

            if (keyFre == leastFrequenly && curList.length() == 0) {
                leastFrequenly++;
            }

            return;
        }

        // Cache is full
        if (countMap.size() == capacity) {
            DoubleLinkedList minList =
                freNodeMap.get(leastFrequenly);

            // Remove least recently used node
            // from the minimum-frequency list.
            Node nodeToRemove = minList.removeFirst();

            countMap.remove(nodeToRemove.key);
        }

        // New node always starts with frequency 1
        Node newNode = new Node(key, value);

        countMap.put(key, 1);

        DoubleLinkedList list =
            freNodeMap.getOrDefault(
                1,
                new DoubleLinkedList()
            );

        list.addLast(newNode);
        freNodeMap.put(1, list);

        leastFrequenly = 1;
    }
}