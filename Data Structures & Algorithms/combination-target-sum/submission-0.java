class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,target,new ArrayList<>(), result);
        return result;
    }

    public void helper(int[] nums, int i, int target, List<Integer> cur, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
        cur.add(nums[i]);
        helper(nums,i,target-nums[i],cur,result);
        cur.remove(cur.size()-1);
        helper(nums,i+1,target,cur,result);
    }
}
