class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>(
            (p1,p2)->{return p2.getValue()-p1.getValue();}
        );
        for(char c : countMap.keySet()){
            pq.add(new Pair<>(c,countMap.get(c)));
        }
        StringBuilder build = new StringBuilder();
        while(pq.size() > 0){
            Pair<Character,Integer> cur = pq.poll(), curNext;
            if(build.length() > 0 && build.charAt(build.length()-1) == cur.getKey()){
                if(pq.size() == 0){
                    return "";
                }
                curNext = pq.poll();
                build.append(curNext.getKey());
                if(curNext.getValue() - 1 > 0){
                    pq.add(new Pair<>(curNext.getKey(), curNext.getValue()-1));
                }
                pq.add(cur);
            }else{
                build.append(cur.getKey());
                if(cur.getValue()-1 > 0){
                    pq.add(new Pair<>(cur.getKey(), cur.getValue()-1));
                }
            }
        }
        return build.toString();
    }
}