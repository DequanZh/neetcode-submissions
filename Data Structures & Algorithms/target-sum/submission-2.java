class Solution {
    Integer[][] cache;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        total = sum;
        cache = new Integer[nums.length][2*sum+1];
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int i, int sum){
        if(sum == target && i == nums.length){
            return 1;
        }
        if(i >= nums.length){
            return 0;
        }
        if(cache[i][sum+total] != null){
            return cache[i][sum+total];
        }
        int add = dfs(nums, target, i+1, sum+nums[i]);
        int subtract = dfs(nums,target, i+1, sum-nums[i]);
        cache[i][sum+total] = add + subtract;
        return cache[i][sum+total];
    }
}
