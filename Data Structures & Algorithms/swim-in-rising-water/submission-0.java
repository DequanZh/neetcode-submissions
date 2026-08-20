class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visted = new boolean[n][n];
        //[i,j,time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->{
            return p1[2] - p2[2];
        });
        pq.offer(new int[]{0,0,grid[0][0]});
        int[][] nextDir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] curPair = pq.poll();
            int x = curPair[0], y = curPair[1], time = curPair[2];
            if(x == n-1 && y == n-1){
                return time;
            }
            visted[x][y] = true;
            for(int[] next : nextDir){
                int dx = x + next[0], dy = y + next[1];
                if(dx >= 0 && dx < n && dy >= 0 && dy < n && !visted[dx][dy]){
                    pq.offer(new int[]{
                        dx,
                        dy,
                        Math.max(time,grid[dx][dy])
                    });
                }
            }
        }
        return -1;
    }
}
