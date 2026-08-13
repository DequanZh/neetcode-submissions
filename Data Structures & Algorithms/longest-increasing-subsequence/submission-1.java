class Solution {
    Integer[][] cache;

    public int lengthOfLIS(int[] nums) {
        cache = new Integer[nums.length][nums.length+2];
        return dfs(nums,0,-1);
    }

    public int dfs(int[] nums, int i, int j){
        if(i == nums.length){
            return 0;
        }
        if(cache[i][j+1] != null){
            return cache[i][j+1];
        }
        int result = dfs(nums,i+1,j);
        if(j == -1 || nums[j] < nums[i]){
            result = Math.max(result,1 + dfs(nums,i+1, i));
        }
        cache[i][j+1] = result;
        return cache[i][j+1];
    }
}
