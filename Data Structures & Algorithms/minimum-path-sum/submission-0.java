class Solution {
    Integer[][] cache;
    public int minPathSum(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length];
        return dfs(grid,0,0);
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length){
            return Integer.MAX_VALUE;
        }
        if(cache[i][j] != null){
            return cache[i][j];
        }
        if(i == grid.length-1 && j == grid[i].length-1){
            return grid[i][j];
        }
        int minSum =  grid[i][j] + Math.min(dfs(grid,i+1,j), dfs(grid,i,j+1));
        return cache[i][j] = minSum;
    }
}