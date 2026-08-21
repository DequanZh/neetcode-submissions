class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }
        for(int i = 0; i < nums.length; i++){
            int key = Math.abs(nums[i]) - 1;
            if(key < 0 || key >= nums.length || nums[key] < 0){
                continue;
            }
            if(nums[key] == 0){
                nums[key] = -1;
            }else{
                nums[key] *= -1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}