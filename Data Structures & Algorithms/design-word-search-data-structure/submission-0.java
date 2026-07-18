class WordDictionary {
    class TriNode {
        boolean isWord = false;
        Map<Character, TriNode> childs = new HashMap<>();
    }

    private TriNode head;

    public WordDictionary() {
        this.head = new TriNode();
    }

    public void addWord(String word) {
        TriNode curHead = head;
        for(char c : word.toCharArray()){
            if(!curHead.childs.containsKey(c)){
                curHead.childs.put(c, new TriNode());
            }
            curHead = curHead.childs.get(c);
        }
        curHead.isWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word,0,head);
    }

    private boolean dfsSearch(String word, int index, TriNode curNode){
        if(curNode == null){
            return false;
        }
        if(index == word.length()){
            return curNode.isWord;
        }
        TriNode curHead = curNode;
        for(int i = index; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                for(char c : curHead.childs.keySet()){
                    if(dfsSearch(word,i+1,curHead.childs.get(c))){
                        return true;
                    }
                }
                return false;
            }
            if(!curHead.childs.containsKey(word.charAt(i))){
                return false;
            }
            curHead = curHead.childs.get(word.charAt(i));
        }
        return curHead.isWord;
    }
}
