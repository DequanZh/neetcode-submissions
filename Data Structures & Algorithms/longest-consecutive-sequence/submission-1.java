class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int maxLength = 0;
        for(int num : nums){
            int length = 0;
            int cur = num;
            while(numSet.contains(cur)){
                numSet.remove(cur);
                cur++;
                length++;
            }
            cur = num-1;
            while(numSet.contains(cur)){
                numSet.remove(cur);
                length++;
                cur--;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
