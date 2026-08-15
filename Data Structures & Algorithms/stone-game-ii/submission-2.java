class Solution {
    Integer[][] cache;
    int[] suffix;
    int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n+1];
        cache = new Integer[n][n];
        for(int i = n-1; i >= 0; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }
        return dfs(1,0);
    }

    public int dfs(int m, int i){
        if(i == n){
            return 0;
        }
        if(i + 2*m >= n){
            return suffix[i];
        }
        if(cache[m][i] != null){
            return cache[m][i];
        }
        int maxStoneValue = 0;
        for(int x = 1; x <= 2*m; x++){
            maxStoneValue = Math.max(maxStoneValue,suffix[i] - dfs(Math.max(x,m), i+x));
        }
        return cache[m][i] = maxStoneValue;
    }
}