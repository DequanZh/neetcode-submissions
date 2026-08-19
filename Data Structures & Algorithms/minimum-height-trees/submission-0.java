class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
        Map<Integer,Integer> edgeCount = new HashMap<>();
        Deque<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(adjMap.get(i).size() == 1){
                leaves.addLast(i);
            }
            edgeCount.put(i, adjMap.get(i).size());
        }
        while(!leaves.isEmpty()){
            int levelSize = leaves.size();
            if(n <= 2){
                return new ArrayList<>(leaves);
            }
            for(int i = 0; i < levelSize; i++){
                int leaf = leaves.removeFirst();
                n--;
                for(int neighbor : adjMap.get(leaf)){
                    int neighborCount = edgeCount.get(neighbor);
                    edgeCount.put(neighbor,neighborCount-1);
                    if(neighborCount-1 == 1){
                        leaves.addLast(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(0));
    }
}