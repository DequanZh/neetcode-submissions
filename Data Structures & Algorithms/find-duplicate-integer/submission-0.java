class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow){
                break;
            }
        }

        int slow2 = 0;
        while(true){
            fast = nums[fast];
            slow2 = nums[slow2];
            if(fast == slow2){
                return fast;
            }
        }
    }
}
