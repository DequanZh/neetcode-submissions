class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,result,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int i, List<List<Integer>> result, List<Integer> cur){
        if(i >= nums.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[i]);
        helper(nums,i+1,result,cur);
        cur.remove(cur.size()-1);
        helper(nums,i+1,result,cur);
    }
}
