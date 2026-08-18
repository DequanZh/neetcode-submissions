class Solution {
    public int jump(int[] nums) {
        int i = 0, r = 0;
        int steps = 0;
        while(r < nums.length-1){
            int maxStep = 0;
            steps++;
            for(int j = i; j <= r; j++){
                maxStep = Math.max(maxStep, j + nums[j]);
            }
            i = r + 1;
            r = maxStep;
        }
        return steps;
    }
}
