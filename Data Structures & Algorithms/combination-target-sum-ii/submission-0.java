class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates,0,target,result,new ArrayList<>());
        return result;
    }

    public void backTrack(int[] candidates, int i, int target, List<List<Integer>> result, List<Integer> cur){
        if(target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 || i >= candidates.length){
            return;
        }
        cur.add(candidates[i]);
        backTrack(candidates,i+1,target-candidates[i],result,cur);
        cur.remove(cur.size()-1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        backTrack(candidates,i+1,target,result,cur);
    }
}
