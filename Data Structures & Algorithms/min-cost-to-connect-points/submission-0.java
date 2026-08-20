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
            if(this.parent[u] != u){
                this.parent[u] = find(this.parent[u]);
            }
            return this.parent[u];
        }

        public boolean union(int u, int v){
            int rootU = find(u), rootV = find(v);
            if(rootU == rootV){
                return false;
            }
            if(this.rank[rootU] > this.rank[rootV]){
                this.rank[rootU] += this.rank[rootV];
                this.parent[rootV] = rootU;
            }else{
                this.rank[rootV] += this.rank[rootU];
                this.parent[rootU] = rootV;
            }
            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        //[p1,p2,cost]
        List<int[]> costPair = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                int[] p1 = points[i], p2 = points[j];
                int cost = Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
                costPair.add(new int[]{i,j,cost});

            }
        }
        Collections.sort(costPair,(p1,p2)->{
            return p1[2] - p2[2];
        });
        UnionFind uf = new UnionFind(points.length);
        int totalCost = 0;
        for(int[] pair : costPair){
            int p1 = pair[0], p2 = pair[1], cost = pair[2];
            if(uf.union(p1,p2)){
                totalCost += cost;
            }
        }
        return totalCost;
    }
}
