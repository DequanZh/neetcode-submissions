class Solution {
    public int climbStairs(int n) {
        int pre = 1, cur = 1;
        while(n > 0){
            int total = pre + cur;
            pre = cur;
            cur = total;
            n--;
        }
        return pre;
    }
}
