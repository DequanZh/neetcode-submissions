class Solution {
    public int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(price < minCost){
                minCost = price;
            }else{
                maxProfit = Math.max(maxProfit,price-minCost);
            }
        }
        return maxProfit;
    }
}
