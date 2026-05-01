class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            for(String word : wordDict){
                if(i + word.length() <= s.length() && s.substring(i,i+word.length()).equals(word)){
                    if(dp[i+word.length()]) break;
                    dp[i+word.length()] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
