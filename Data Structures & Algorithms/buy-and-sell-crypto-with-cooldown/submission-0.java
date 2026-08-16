class Solution {
    Integer[][] cache;
    public int maxProfit(int[] prices) {
        cache = new Integer[prices.length][2];
        return dfs(prices,0,true);
    }

    public int dfs(int[] prices, int i, boolean coolDown){
        if(i >= prices.length){
            return 0;
        }
        if(cache[i][coolDown ? 1 : 0] != null){
            return cache[i][coolDown ? 1 : 0];
        }
        int next = dfs(prices,i+1,coolDown);
        if(coolDown){
            return cache[i][1] = Math.max(next, dfs(prices,i+1,false) - prices[i]);
        }
        return cache[i][0] = Math.max(next, dfs(prices,i+2,true) + prices[i]);
    }
}
