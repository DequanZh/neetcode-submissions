class PrefixTree {
    class Node{
        boolean isWord = false;
        Map<Character,Node> childs = new HashMap<>();
    }

    Node head = new Node();

    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node curHead = head;
        for(char c : word.toCharArray()){
            if(!curHead.childs.containsKey(c)){
                curHead.childs.put(c, new Node());
            }
            curHead = curHead.childs.get(c);
        }
        curHead.isWord = true;
    }

    public boolean search(String word) {
        Node curHead = head;
        for(char c : word.toCharArray()){
            if(!curHead.childs.containsKey(c)){
                return false;
            }
            curHead = curHead.childs.get(c);
        }
        return curHead.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curHead = head;
        for(char c : prefix.toCharArray()){
            if(!curHead.childs.containsKey(c)){
                return false;
            }
            curHead = curHead.childs.get(c);
        }
        return dfs(curHead);
    }

    public boolean dfs(Node curNode){
        if(curNode == null){
            return false;
        }
        if(curNode.isWord){
            return true;
        }
        for(char c : curNode.childs.keySet()){
            if(dfs(curNode.childs.get(c))){
                return true;
            }
        }
        return false;
    }
}
