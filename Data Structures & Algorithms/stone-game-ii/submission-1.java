class Solution {
    Integer[][][] cache;
    public int stoneGameII(int[] piles) {
        cache = new Integer[piles.length+1][piles.length][2];
        return dfs(piles,1,0,true);
    }

    public int dfs(int[] piles, int m, int i, boolean alice){
        if(i == piles.length){
            return 0;
        }
        if(cache[m][i][alice ? 1 : 0] != null){
            return cache[m][i][alice ? 1 : 0];
        }
        int maxStone = alice ? 0 : Integer.MAX_VALUE;
        int total = 0;
        for(int x = 1; x <= 2*m; x++){
            if(i + x > piles.length) break;
            if(alice){
                total += piles[i+x-1];
                maxStone = Math.max(maxStone, total + dfs(piles, Math.max(x,m),i+x,false));
            }else{
                maxStone = Math.min(maxStone, dfs(piles,Math.max(x,m),i+x,true));
            }
        }
        return cache[m][i][alice ? 1 : 0] = maxStone;
    }
}