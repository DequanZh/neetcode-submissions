class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            adjMap.get(prereq[0]).add(prereq[1]);
        }
        Map<Integer,Boolean> vistedMap = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(dfs(adjMap,vistedMap,i,order)){
                return new int[0];
            }
        }
        //System.out.println(order);
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = order.get(i);
        }
        return result;
    }

    public boolean dfs(Map<Integer,List<Integer>> adjMap,Map<Integer,Boolean> vistedMap, int node, List<Integer> order){
        if(vistedMap.containsKey(node)){
            return vistedMap.get(node);
        }
        vistedMap.put(node,true);
        for(int next : adjMap.get(node)){
            if(dfs(adjMap,vistedMap,next,order)){
                return true;
            }
        }
        vistedMap.put(node,false);
        order.add(node);
        return false;
    }
}
