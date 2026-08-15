class Solution {
    Integer[][] cache;
    public int change(int amount, int[] coins) {
        cache = new Integer[amount+1][coins.length];
        return dfs(amount,coins,0);
    }

    public int dfs(int amount, int[] coins, int i){
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || i == coins.length){
            return 0;
        }
        if(cache[amount][i] != null){
            return cache[amount][i];
        }
        int count = 0;
        count += dfs(amount, coins, i+1);
        count += dfs(amount-coins[i],coins,i);
        return cache[amount][i] = count;
    }
}
