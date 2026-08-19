class Solution {
    class UnionFind{
        int[] parent, rank;
        int components;

        public UnionFind(int n){
            this.components = n;
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i = 0; i < n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int u){
            if(parent[u] != u){
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        public boolean union(int u, int v){
            int rootU = find(u), rootV = find(v);
            //detec cycle
            if(rootU == rootV){
                return false;
            }
            this.components--;
            if(rank[rootU] > rank[rootV]){
                rank[rootU] += rank[rootV];
                parent[rootV] = rootU;
            }else{
                rank[rootV] += rank[rootU];
                parent[rootU] = rootV;
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        /*
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
        */
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return uf.components == 1;
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
