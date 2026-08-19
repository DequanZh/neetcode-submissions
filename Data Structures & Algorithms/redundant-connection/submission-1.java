class Solution {
    class UnionFind{
        int[] parent, rank;
        
        public UnionFind(int n){
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
            if(rootU == rootV){
                return false;
            }
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
    public int[] findRedundantConnection(int[][] edges) {
        /*
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
        */
        UnionFind uf = new UnionFind(edges.length+1);
        int[] result = null;
        for(int[] edge : edges){
            if(!uf.union(edge[0],edge[1])){
                result = edge;
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
