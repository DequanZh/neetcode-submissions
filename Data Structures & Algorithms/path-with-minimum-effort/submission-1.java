class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effortMap = new int[m][n];
        for(int[] row : effortMap){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->{
            return p1[2] - p2[2];
        });
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curPair = pq.poll();
            int x = curPair[0], y = curPair[1], effort = curPair[2];
            if(effort > effortMap[x][y]) continue;
            if(x == m-1 && y == n-1){
                return effort;
            }
            for(int[] next : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}){
                int dx = x + next[0], dy = y + next[1];
                if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                    int curEffort = Math.max(effort,Math.abs(heights[x][y]-heights[dx][dy]));
                    if(curEffort < effortMap[dx][dy]){
                        effortMap[dx][dy] = curEffort;
                        pq.offer(new int[]{dx,dy,curEffort});
                    }
                }
            }
        }
        return 0;
    }
}