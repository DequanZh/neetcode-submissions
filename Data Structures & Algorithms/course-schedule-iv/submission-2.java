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
            int prereq = query[0], course = query[1];
            result.add(dfs(adjMap,course,prereq));
        }
        return result;
    }

    public boolean dfs(Map<Integer,List<Integer>> adjMap, int course, int prereq){
        if(prereq == course){
            return true;
        }
        if(cache[prereq][course] != null){
            return cache[prereq][course];
        }
        for(int nextPrereque : adjMap.get(course)){
            if(dfs(adjMap,nextPrereque,prereq)){
                cache[prereq][course] = true;
                return true;
            }
        }
        cache[prereq][course] = false;
        return false;
    }
}