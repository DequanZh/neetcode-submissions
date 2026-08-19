class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] prere : prerequisites){
            adjMap.get(prere[1]).add(prere[0]);
        }
        Map<Integer,Boolean> vistedMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            //contains cycyle
            if(dfs(adjMap,vistedMap,i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer,List<Integer>> adjMap, Map<Integer,Boolean> vistedMap, int node){
        if(vistedMap.containsKey(node)){
            return vistedMap.get(node);
        }
        vistedMap.put(node, true);
        for(int next : adjMap.get(node)){
            if(dfs(adjMap,vistedMap,next)){
                return true;
            }
        }
        vistedMap.put(node,false);
        return false;
    }
}
