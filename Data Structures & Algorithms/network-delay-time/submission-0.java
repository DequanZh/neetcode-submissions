class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTime = new int[n+1];
        int[][] timeCost = new int[n+1][n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0], v = time[1], cost = time[2];
            timeCost[u][v] = cost;
            adjMap.get(u).add(v);
        }
        minTime[k] = 0;
        //[node, time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->{
            return p1[1] - p2[1];
        });
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curPair = pq.poll();
            int node = curPair[0], time = curPair[1];
            if(time > minTime[node]){
                continue;
            }
            if(n == 1){
                return time;
            }
            n--;
            for(int nextNode : adjMap.get(node)){
                int timeToReach = minTime[node] + timeCost[node][nextNode];
                if(timeToReach < minTime[nextNode]){
                    minTime[nextNode] = timeToReach;
                    pq.offer(new int[]{nextNode, timeToReach});
                }
            }
        }
        return -1;
    }
}
