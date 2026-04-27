class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0, left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < nums.length){
            curSum += nums[right];
            while(curSum >= target && left <= right){
                minLength = Math.min(minLength, right-left+1);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}