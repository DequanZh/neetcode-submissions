class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshFruit = 0;
        Deque<int[]> queue = new LinkedList<>();
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y] == 2){
                    queue.addLast(new int[]{x,y});
                }
                if(grid[x][y] == 1){
                    freshFruit++;
                }
            }
        }
        while(queue.size() > 0 && freshFruit > 0){
            int curSize = queue.size();
            while(curSize > 0){
                int[] pos = queue.removeFirst();
                int x = pos[0], y = pos[1];
                for(int[] next : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}){
                    int nextX = x+next[0], nextY = y+next[1];
                    if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[nextX].length &&
                    grid[nextX][nextY] == 1){
                        queue.addLast(new int[]{nextX,nextY});
                        grid[nextX][nextY] = 2;
                        freshFruit--;
                    }
                }
                curSize--;
            }
            minutes++;
        }
        if(freshFruit > 0){
            return -1;
        }
        return minutes;
    }
}
