class Solution {
    Integer[] cache;

    public int lengthOfLIS(int[] nums) {
        cache = new Integer[nums.length];
        Arrays.fill(cache,-1);
        int result = 1;
        for(int i = 0; i < nums.length; i++){
            result = Math.max(result, dfs(nums,i));
        }
        return result;
    }

    public int dfs(int[] nums, int i){
        if(cache[i] != -1){
            return cache[i];
        }
        int result = 1;
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] < nums[j]){
                result = Math.max(result, 1 + dfs(nums,j));
            }
        }
        cache[i] = result;
        return result;
    }
}
