class Solution {
    Map<Integer,Integer> cache = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(0,cost),helper(1,cost));
    }

    public int helper(int i, int[] cost){
        if(i >= cost.length){
            return 0;
        }
        if(cache.containsKey(i)){
            return cache.get(i);
        }

        cache.put(i, cost[i] + Math.min(helper(i+1,cost), helper(i+2,cost)));
        return cache.get(i);
    }
}
