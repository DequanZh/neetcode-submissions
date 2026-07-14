class Solution {
    Map<Integer,Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        return helper(0,nums);
    }

    public int helper(int i, int[] nums){
        if(i >= nums.length){
            return 0;
        }
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        int max = Math.max(nums[i] + helper(i+2,nums), helper(i+1,nums));
        cache.put(i,max);
        return cache.get(i);
    }
}
