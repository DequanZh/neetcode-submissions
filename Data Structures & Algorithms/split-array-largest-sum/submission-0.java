class Solution {
    public int splitArray(int[] nums, int k) {
        int left = nums[0], right = 0;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canSplit(nums,mid,k)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right+1;
    }

    private boolean canSplit(int[] nums, int sum, int k){
        int subArrays = 1;
        int sumVal = 0;
        for(int num : nums){
            if(sumVal + num <= sum){
                sumVal += num;
            }else{
                subArrays++;
                sumVal = num;
            }
        }
        return subArrays <= k;
    }
}