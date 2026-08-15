class Solution {
    Integer[] cache;
    public String stoneGameIII(int[] stoneValue) {
        cache = new Integer[stoneValue.length];
        int result = dfs(stoneValue,0);
        if(result == 0){
            return "Tie";
        }
        return result > 0 ? "Alice" : "Bob";
    }

    private int dfs(int[] stoneValue, int i){
        if(i == stoneValue.length){
            return 0;
        }
        if(cache[i] != null){
            return cache[i];
        }
        int score = 0, maxScore = Integer.MIN_VALUE;
        for(int p = i; p < Math.min(i+3, stoneValue.length); p++){
            score += stoneValue[p];
            maxScore = Math.max(maxScore, score - dfs(stoneValue,p+1));
        }
        return cache[i] = maxScore;
    }
}