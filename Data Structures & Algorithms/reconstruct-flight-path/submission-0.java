class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,LinkedList<String>> adjMap = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0), to = ticket.get(1);
            if(!adjMap.containsKey(from)){
                adjMap.put(from, new LinkedList<>());
            }
            if(!adjMap.containsKey(to)){
                adjMap.put(to, new LinkedList<>());
            }
            adjMap.get(from).addLast(to);
        }
        for(String from : adjMap.keySet()){
            Collections.sort(adjMap.get(from));
        }
        List<String> result = new ArrayList<>();
        dfs(adjMap,"JFK",result);
        Collections.reverse(result);
        return result;
    }

    public void dfs(Map<String,LinkedList<String>> adjMap, String cur, List<String> result){
        if(!adjMap.containsKey(cur)){
            return;
        }
        LinkedList<String> curList = adjMap.get(cur);
        while(curList.size() > 0){
            dfs(adjMap, curList.removeFirst(), result);
        }
        adjMap.remove(cur);
        result.add(cur);
    }
}
