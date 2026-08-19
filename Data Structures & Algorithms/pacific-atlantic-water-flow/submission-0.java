class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for(int r = 0; r < n; r++){
            dfs(heights,pacific,r,0);
            dfs(heights,atlantic,r,m-1);
        }
        for(int c = 0; c < m; c++){
            dfs(heights,pacific,0,c);
            dfs(heights,atlantic,n-1,c);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if(pacific[x][y] && atlantic[x][y]){
                    result.add(Arrays.asList(new Integer[]{x,y}));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, boolean[][] ocean, int x, int y){
        ocean[x][y] = true;
        for(int[] next : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}){
            int dx = x + next[0], dy = y + next[1];
            if(dx >= 0 && dx < heights.length && dy >= 0 && dy < heights[dx].length && !ocean[dx][dy] && heights[x][y] <= heights[dx][dy]){
                dfs(heights,ocean,dx,dy);
            }
        }
    }
}
