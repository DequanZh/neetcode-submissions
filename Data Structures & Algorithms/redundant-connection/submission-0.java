class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i <= edges.length; i++){
            adjMap.put(i, new ArrayList<>());
        }
        int[] result = null;
        for(int[] edge : edges){
            if(dfs(adjMap,edge[0],-1,edge[1])){
                result = edge;
            }else{
                adjMap.get(edge[0]).add(edge[1]);
                adjMap.get(edge[1]).add(edge[0]);
            }
        }
        return result;
    }

    public boolean dfs(Map<Integer,List<Integer>> adjMap, int from, int parent, int to){
        if(from == to){
            return true;
        }
        for(int next : adjMap.get(from)){
            if(parent == next) continue;
            if(dfs(adjMap,next,from,to)){
                return true;
            }
        }
        return false;
    }
}
