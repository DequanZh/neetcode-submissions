class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> queue = new LinkedList<>();
        if(!wordSet.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        queue.addLast(beginWord);
        int steps = 0;
        while(!queue.isEmpty()){
            int leavelSize = queue.size();
            steps++;
            for(int i = 0; i < leavelSize; i++){
                String curStr = queue.removeFirst();
                if(curStr.equals(endWord)){
                    return steps;
                }
                for(int j = 0; j < curStr.length(); j++){
                    char[] strArray = curStr.toCharArray();
                    for(int k = 0; k <= 26; k++){
                        strArray[j] = (char)(k + 'a');
                        String cur = new String(strArray);
                        if(wordSet.contains(cur)){
                            queue.addLast(cur);
                            wordSet.remove(cur);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
