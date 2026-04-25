class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        //[-1,0,1,2,-1,-4]
        //[-4,-1,-1,0,1,2]
        while(i < nums.length){
            int j = i+1, k = nums.length-1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> pair = Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(pair);
                    int curNum = nums[k];
                    while(k > j && curNum == nums[k]){
                        k--;
                    }        
                }
                if(nums[j] + nums[k] + nums[i] > 0){
                    k--;
                }else{
                    j++;
                }
            }
            int curVal = nums[i];
            while(i < nums.length && curVal == nums[i]){
                i++;
            }
        }
        return result;
    }
}
