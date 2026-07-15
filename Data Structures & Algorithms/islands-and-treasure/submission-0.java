class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y] == 0){
                    queue.addLast(new int[]{x,y,0});
                }
            }
        }
        while(queue.size() > 0){
            int curSize = queue.size();
            while(curSize > 0){
                int[] curPos = queue.removeFirst();
                int curX = curPos[0];
                int curY = curPos[1];
                int steps = curPos[2];
                if(grid[curX][curY] == -1){
                    continue;
                }
                if(grid[curX][curY] > 0){
                    grid[curX][curY] = Math.min(grid[curX][curY],steps);
                }
                for(int[] next : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}){
                    int nextX = curX + next[0];
                    int nextY = curY + next[1];
                    if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[nextX].length && grid[nextX][nextY] == Integer.MAX_VALUE){
                        queue.add(new int[]{nextX,nextY,steps+1});
                    }
                }
                curSize--;
            }
        }
    }
}
