class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for(String deadend : deadends){
            deadSet.add(deadend);
        }
        if(deadSet.contains("0000")){
            return -1;
        }
        Deque<String> queue = new LinkedList<>();
        queue.addLast("0000");
        int steps = 0;
        while(!queue.isEmpty()){
            int curLevelSize = queue.size();
            steps++;
            for(int i = 0; i < curLevelSize; i++){
                String cur = queue.poll();
                for(int j = 0; j < 4; j++){
                    for(int diff : new int[]{1,-1}){
                        char[] curArray = cur.toCharArray();
                        curArray[j] = (char)((curArray[j] - '0' + diff + 10)%10 + '0');
                        String curStr = new String(curArray);
                        if(deadSet.contains(curStr)){
                            continue;
                        }
                        if(curStr.equals(target)){
                            return steps;
                        }
                        deadSet.add(curStr);
                        queue.addLast(curStr);
                    }
                }
            }
        }
        return -1;
    }
}