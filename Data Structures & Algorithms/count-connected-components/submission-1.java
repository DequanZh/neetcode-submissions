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

        public void union(int u, int v){
            int rootU = find(u), rootV = find(v);
            if(rootU == rootV){
                return;
            }
            this.components--;
            if(rank[rootU] > rank[rootV]){
                rank[rootU] += rank[rootV];
                parent[rootV] = rootU;
            }else{
                rank[rootV] += rank[rootU];
                parent[rootU] = rootV;
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        /*
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
        */

        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.components;
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
