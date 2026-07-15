class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, x, y));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y >= grid[x].length || y < 0 ||
        grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;
        int area = dfs(grid, x+1, y) + dfs(grid, x-1, y) + dfs(grid, x, y+1) + dfs(grid, x, y-1);
        return 1 + area;
    }
}
