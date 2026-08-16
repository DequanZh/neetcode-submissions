class Solution {
    Integer[][] cache;
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
        int preSold = sold;

        sold = held + price;
        held = Math.max(held, reset - price);
        reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }

    public int dfs(int[] prices, int i, boolean buying){
        if(i >= prices.length){
            return 0;
        }
        if(cache[i][buying ? 1 : 0] != null){
            return cache[i][buying ? 1 : 0];
        }
        int next = dfs(prices,i+1,buying);
        if(buying){
            return cache[i][1] = Math.max(next, dfs(prices,i+1, false) - prices[i]);
        }
        return cache[i][0] = Math.max(next, dfs(prices,i+2,true) + prices[i]);
    }
}
