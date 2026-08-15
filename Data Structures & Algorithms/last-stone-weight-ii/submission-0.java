class Solution {
    Integer[][] cache;
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        cache = new Integer[sum][stones.length];
        int target = (int)Math.ceil(sum/2);
        return dfs(stones,sum,target,0,0);
    }

    private int dfs(int[] stones, int sum, int target, int curTotal, int i){
        if(i == stones.length || curTotal >= target){
            return Math.abs((curTotal - (sum-curTotal)));
        }
        if(cache[curTotal+target][i] != null){
            return cache[curTotal+target][i];
        }
        return cache[curTotal+target][i] = Math.min(dfs(stones,sum,target,curTotal+stones[i],i+1), dfs(stones,sum,target,curTotal,i+1));
    }
}