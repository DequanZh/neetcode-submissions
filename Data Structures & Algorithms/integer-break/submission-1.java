class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int integerBreak(int n) {
        if(n <= 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        return dfs(n);
    }

    public int dfs(int n){
        if(n < 0){
            return 0;
        }
        if(n == 1 || n == 0){
            return 1;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int max = Math.max(2*dfs(n-2), 3*dfs(n-3));
        cache.put(n,max);
        return max;
    }
}