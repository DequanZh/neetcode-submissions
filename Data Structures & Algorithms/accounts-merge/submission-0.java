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

        public void union(int u, int v){
            int rootU = find(u), rootV = find(v);
            if(rootU == rootV){
                return;
            }
            if(rank[rootU] > rank[rootV]){
                rank[rootU] += rank[rootV];
                parent[rootV] = rootU;
            }else{
                rank[rootV] += rank[rootU];
                parent[rootU] = rootV;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String,Integer> emailToIndexMap = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(emailToIndexMap.containsKey(email)){
                    uf.union(emailToIndexMap.get(email),i);
                }else{
                    emailToIndexMap.put(email,i);
                }
            }
        }
        Map<Integer, Set<String>> resultMap = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            int parent = uf.find(i);
            if(!resultMap.containsKey(parent)){
                resultMap.put(parent,new HashSet<>());
            }
            Set<String> curSet = resultMap.get(parent);
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                curSet.add(account.get(j));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(int parent : resultMap.keySet()){
            List<String> mergedList = new ArrayList<>();
            mergedList.add(accounts.get(parent).get(0));
            List<String> emailList = new ArrayList<>(resultMap.get(parent));
            Collections.sort(emailList);
            mergedList.addAll(emailList);
            result.add(mergedList);
        }
        return result;
    }
}