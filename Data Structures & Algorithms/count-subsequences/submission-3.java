class Solution {
    Integer[][] cache;
    public int numDistinct(String s, String t) {
        cache = new Integer[s.length()][t.length()];
        return dfs(s,t,0,0);
    }

    public int dfs(String s, String t, int j, int i){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(cache[i][j] != null){
            return cache[i][j];
        }
        int count = 0;
        count += dfs(s,t,j,i+1);
        if(s.charAt(i) == t.charAt(j))
            count += dfs(s,t,j+1,i+1);
        return cache[i][j] = count;
    }
}
