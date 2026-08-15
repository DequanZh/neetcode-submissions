class Solution {
    Map<String,Integer>[] cache;
    public int numDistinct(String s, String t) {
        cache = new HashMap[s.length()];
        for(int i = 0; i < s.length(); i++){
            cache[i] = new HashMap<>();
        }
        return dfs(s,t,new StringBuilder(), 0);
    }

    public int dfs(String s, String t, StringBuilder build, int i){
        if(i == s.length()){
            return build.toString().equals(t) ? 1 : 0;
        }
        if(build.toString().equals(t)){
            return 1;
        }
        if(cache[i].containsKey(build.toString())){
            return cache[i].get(build.toString());
        }
        int count = 0;
        build.append(s.charAt(i));
        count += dfs(s,t,build,i+1);
        build.deleteCharAt(build.length()-1);
        count += dfs(s,t,build,i+1);
        cache[i].put(build.toString(),count);
        return count;
    }
}
