class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        Map<Integer,Integer> diffMap = new HashMap<>();
        diffMap.put(0,1);
        int result = 0;
        for(int num : nums){
            total += num;
            int diff = total - k;
            result += diffMap.getOrDefault(diff,0);
            diffMap.put(total, diffMap.getOrDefault(total,0)+1);
        }
        return result;
    }
}