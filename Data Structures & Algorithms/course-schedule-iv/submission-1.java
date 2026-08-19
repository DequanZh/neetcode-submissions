class Solution {
    Boolean[][] cache;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            adjMap.get(prereq[1]).add(prereq[0]);
        }
        List<Boolean> result = new ArrayList<>();
        cache = new Boolean[numCourses][numCourses];
        for(int[] query : queries){
            int from = query[0], to = query[1];
            result.add(dfs(adjMap,to,from));
        }
        return result;
    }

    public boolean dfs(Map<Integer,List<Integer>> adjMap, int to, int from){
        if(from == to){
            return true;
        }
        if(cache[from][to] != null){
            return cache[from][to];
        }
        for(int next : adjMap.get(to)){
            if(dfs(adjMap,next,from)){
                cache[from][to] = true;
                return true;
            }
        }
        cache[from][to] = false;
        return false;
    }
}