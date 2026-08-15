class Solution {
    Integer[][] cache;
    public int maxCoins(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        for(int num : nums){
            numList.add(num);
        }
        numList.add(1);
        cache = new Integer[numList.size()][numList.size()];
        return dfs(numList, 1, numList.size()-2);
    }

    public int dfs(List<Integer> numList, int l, int r){
        if(l > r){
            return 0;
        }
        if(cache[l][r] != null){
            return cache[l][r];
        }
        int maxScore = 0;
        for(int i = l; i <= r; i++){
            int curScore = numList.get(l-1) * numList.get(i) * numList.get(r+1);
            curScore += dfs(numList,l,i-1) + dfs(numList,i+1,r);
            maxScore = Math.max(maxScore, curScore); 
        }
        return cache[l][r] = maxScore;
    }
}
