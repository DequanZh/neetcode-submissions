class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicateSet = new HashSet<>();
        for(int num : nums){
            if(duplicateSet.contains(num)){
                return true;
            }
            duplicateSet.add(num);
        }
        return false;
    }
}