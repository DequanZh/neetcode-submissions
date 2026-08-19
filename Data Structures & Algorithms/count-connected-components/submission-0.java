class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
        int components = 0;
        Set<Integer> visted = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(!visted.contains(i)){
                components++;
                dfs(adjMap,visted,i,-1);
            }
        }
        return components;
    }

    public void dfs(Map<Integer,List<Integer>> adjMap, Set<Integer> visted, int node, int parent){
        if(visted.contains(node)){
            return;
        }
        visted.add(node);
        for(int next : adjMap.get(node)){
            if(parent != node){
                dfs(adjMap,visted,next,node);
            }
        }
    }
}
