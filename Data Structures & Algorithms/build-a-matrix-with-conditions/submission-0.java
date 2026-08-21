class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer,List<Integer>> rowMap = new HashMap<>(), colMap = new HashMap<>();
        for(int i = 1; i <= k; i++){
            rowMap.put(i, new ArrayList<>());
            colMap.put(i, new ArrayList<>());
        }
        for(int[] rowCon : rowConditions){
            rowMap.get(rowCon[1]).add(rowCon[0]);
        }
        for(int[] colCon : colConditions){
            colMap.get(colCon[1]).add(colCon[0]);
        }
        Map<Integer,Integer> rowOrder = new HashMap<>(), colOrder = new HashMap<>();
        Map<Integer, Boolean> vistedMap = new HashMap<>();
        for(int i = 1; i <= k; i++){
            if(topoSort(rowMap,rowOrder,i,vistedMap)){
                return new int[0][0];
            }
        }
        vistedMap = new HashMap<>();
        for(int i = 1; i <= k; i++){
            if(topoSort(colMap,colOrder,i,vistedMap)){
                return new int[0][0];
            }
        }
        int[][] result = new int[k][k];
        for(int i = 1; i <= k; i++){
            int x = rowOrder.get(i);
            int y = colOrder.get(i);
            result[x][y] = i;
        }
        return result;
    }

    public boolean topoSort(Map<Integer,List<Integer>> adjMap, Map<Integer,Integer> orderMap, int cur, Map<Integer, Boolean> vistedMap){
        if(vistedMap.containsKey(cur)){
            return vistedMap.get(cur);
        }
        vistedMap.put(cur,true);
        for(int next : adjMap.get(cur)){
            if(topoSort(adjMap,orderMap,next,vistedMap)){
                return true;
            }
        }
        vistedMap.put(cur,false);
        orderMap.put(cur,orderMap.size());
        return false;
    }
}