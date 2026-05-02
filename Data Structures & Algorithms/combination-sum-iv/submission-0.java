class Solution {
    Map<Integer,Integer> cache = new HashMap<>();
    
    public int combinationSum4(int[] nums, int target) {
        return dfs(nums,target);
    }

    public int dfs(int[] nums, int target){
        if(target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        if(cache.containsKey(target)){
            return cache.get(target);
        }
        int result = 0;
        for(int num : nums){
            result += dfs(nums,target-num);
        }
        cache.put(target,result);
        return result;
    }
}