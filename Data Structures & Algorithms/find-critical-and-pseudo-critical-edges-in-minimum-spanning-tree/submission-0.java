class Solution {
    class UnionFind{
        int[] rank, parent;
        int components;

        public UnionFind(int n){
            this.rank = new int[n];
            this.parent = new int[n];
            this.components = n;

            for(int i = 0; i < n; i++){
                this.rank[i] = 1;
                this.parent[i] = i;
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
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //[i,u,v,weight]
        List<int[]> edgeList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            edgeList.add(new int[]{i,edges[i][0],edges[i][1],edges[i][2]});
        }
        Collections.sort(edgeList,(e1,e2)->{
            return e1[3]-e2[3];
        });
        List<Integer> critcal = new ArrayList<>(), pseudo = new ArrayList<>();
        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edgeList){
            if(uf.union(edge[1],edge[2])){
                mstWeight += edge[3];
            }
        }

        for(int i = 0; i < edgeList.size(); i++){
            int[] edge = edgeList.get(i);
            int originalIndex = edge[0], u = edge[1], v = edge[2], weight = edge[3];
            uf = new UnionFind(n);
            int curWeight = 0;
            for(int j = 0; j < edgeList.size(); j++){
                int[] curEdge = edgeList.get(j);
                if(i != j && uf.union(curEdge[1],curEdge[2])){
                    curWeight += curEdge[3];
                }
            } 
            if(uf.components > 1 || curWeight > mstWeight){
                critcal.add(originalIndex);
                continue;
            }
            uf = new UnionFind(n);
            uf.union(u,v);
            curWeight = weight;
            for(int j = 0; j < edgeList.size(); j++){
                int[] curEdge = edgeList.get(j);
                if(i != j && uf.union(curEdge[1],curEdge[2])){
                    curWeight += curEdge[3];
                }
            }
            if(curWeight == mstWeight){
                pseudo.add(originalIndex);
            }
        }
        return Arrays.asList(critcal,pseudo);
    }
}