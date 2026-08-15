class Solution {
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 == 1){
            return false;
        }
        int target = sum/2;
        cache = new Boolean[nums.length][target+1];
        return dfs(nums,0,target);
    }

    public boolean dfs(int[] nums, int i, int target){
        if(target < 0 || i >= nums.length){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(cache[i][target] != null){
            return cache[i][target];
        }
        boolean result = dfs(nums,i+1,target-nums[i]) || dfs(nums,i+1,target);
        cache[i][target] = result;
        return result;
    }
}
