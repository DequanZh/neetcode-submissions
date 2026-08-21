class Solution {
    class UnionFind{
        int[] parent, rank;
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

    public boolean canTraverseAllPairs(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(uf.find(i) == uf.find(j)){
                    continue;
                }
                if(gcd(nums[i],nums[j]) > 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.components == 1;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}