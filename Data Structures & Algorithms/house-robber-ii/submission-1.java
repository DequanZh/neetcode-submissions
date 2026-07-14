class Solution {
    Map<Integer,Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        } 
        int rob1 = helper(0,nums,nums.length-2);
        cache = new HashMap<>();
        int rob2 = helper(1,nums,nums.length-1);
        return Math.max(rob1,rob2);
    }

    public int helper(int i, int[] nums, int limit){
        if(i > limit){
            return 0;
        }
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        int max = Math.max(nums[i] + helper(i+2,nums, limit), helper(i+1,nums,limit));
        cache.put(i,max);
        return cache.get(i);
    }
}
