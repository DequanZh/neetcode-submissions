class Solution {
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k > 0){
            return false;
        }
        int target = sum / k;
        used = new boolean[nums.length];
        return dfs(nums,k,0,target);
    }

    public boolean dfs(int[] nums, int k, int sum, int target){
        if(k == 0){
            return true;
        }
        if(sum == target){
            return dfs(nums,k-1,0,target);
        }
        if(sum > target){
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                if(dfs(nums,k,sum+nums[i],target)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}