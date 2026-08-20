class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //[node,distance,k]
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->{
            return p1[1] - p2[1];
        });
        //[src, [[des,cost]]]
        Map<Integer,List<int[]>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] flight : flights){
            adjMap.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[][] price = new int[n][k+2];
        for(int[] p : price){
            Arrays.fill(p, Integer.MAX_VALUE);
        }
        price[src][k+1] = 0;
        pq.offer(new int[]{src,0,k+1});
        while(!pq.isEmpty()){
            int[] curPair = pq.poll();
            int cur = curPair[0], curCost = curPair[1], stops = curPair[2];
            if(cur == dst){
                return curCost;
            }
            for(int[] nextNode : adjMap.get(cur)){
                int next = nextNode[0], cost = nextNode[1];
                if(stops-1 >= 0 && cost+curCost < price[next][stops-1]){
                    price[next][stops-1] = cost+curCost;
                    pq.offer(new int[]{next,cost+curCost,stops-1});
                }
            }
        }
        return -1;
    }
}
