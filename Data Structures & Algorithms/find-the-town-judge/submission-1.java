class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for(int[] t : trust){
            inDegree[t[1]]++;
            outDegree[t[0]]++;
        }
        int judge = -1;
        for(int i = 0; i <= n; i++){
            if(inDegree[i] == n-1 && outDegree[i] == 0){
                if(judge != -1){
                    return -1;
                }
                judge = i;
            }
        }
        return judge;
    }
}