class Solution {
    Integer[][][] cache;
    public int findMaxForm(String[] strs, int m, int n) {
        cache = new Integer[m+1][n+1][strs.length];
        return dfs(strs,m,n,0);
    }

    public int dfs(String[] strs, int m, int n, int i){
        if(i == strs.length){
            return 0;
        }
        if(cache[m][n][i] != null){
            return cache[m][n][i];
        }
        int zeroCount = 0, oneCount = 0;
        for(int j = 0; j < strs[i].length(); j++){
            if(strs[i].charAt(j) == '0'){
                zeroCount++;
            }else{
                oneCount++;
            }
        }
        int take = m-zeroCount >= 0 && n-oneCount >= 0 ? 1 + dfs(strs,m-zeroCount,n-oneCount,i+1) : 0;
        return cache[m][n][i] = Math.max(take, dfs(strs,m,n,i+1));
    }
}