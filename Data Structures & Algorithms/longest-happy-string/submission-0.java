class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((p1,p2)->{
            return -p1.getValue()+p2.getValue();
        });
        if(a > 0)pq.add(new Pair<Character,Integer>('a',a));
        if(b > 0)pq.add(new Pair<Character,Integer>('b',b));
        if(c > 0)pq.add(new Pair<Character,Integer>('c',c));
        StringBuilder build = new StringBuilder();
        while(pq.size() > 0){
            Pair<Character,Integer> cur = pq.poll();
            if(build.length() >= 2 && build.charAt(build.length()-1) == cur.getKey() && 
            build.charAt(build.length()-2) == cur.getKey()){
                if(pq.size() == 0){
                    return build.toString();
                }
                Pair<Character,Integer> curNext = pq.poll();
                build.append(curNext.getKey());
                if(curNext.getValue()-1 > 0)
                    pq.add(new Pair<Character,Integer>(curNext.getKey(),curNext.getValue()-1));
                pq.add(cur);
            }else{
                build.append(cur.getKey());
                if(cur.getValue()-1 > 0){
                    pq.add(new Pair<Character,Integer>(cur.getKey(),cur.getValue()-1));
                }
            }
        }
        return build.toString();
    }
}