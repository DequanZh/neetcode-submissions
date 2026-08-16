class Solution {
    Boolean[][] cache;
    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length()+1][p.length()];
        return dfs(s,p,0,0);
    }

    public boolean dfs(String s, String p, int i, int j){
        if(j == p.length()){
            return i == s.length();
        }
        if(cache[i][j] != null){
            return cache[i][j];
        }
        boolean matched = i < s.length() && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'));
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            cache[i][j] = dfs(s,p,i,j+2) || (matched && dfs(s,p,i+1,j));
            return cache[i][j];
        }
        if(matched){
            cache[i][j] = dfs(s,p,i+1,j+1);
            return cache[i][j];
        }
        return cache[i][j] = false;
    }
}
