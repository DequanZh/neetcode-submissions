class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
        Map<Integer,Boolean> vistedMap = new HashMap<>();
        if(dfs(adjMap,vistedMap,0,-1)){
            return false;
        }
        return vistedMap.size() == n;
    }

    private boolean dfs(Map<Integer,List<Integer>> adjMap, Map<Integer,Boolean> vistedMap, int node, int parent){
        if(vistedMap.containsKey(node)){
            return vistedMap.get(node);
        }
        vistedMap.put(node,true);
        for(int next : adjMap.get(node)){
            if(next == parent) continue;
            if(dfs(adjMap,vistedMap,next,node)){
                return true;
            }
        }
        vistedMap.put(node,false);
        return false;
    }
}
