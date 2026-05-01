class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        for(int[] interval : intervals){
            if(newInterval == null || newInterval[0] > interval[1]){
                resultList.add(interval);
            }
            else if (interval[0] > newInterval[1]) {
                resultList.add(newInterval);
                resultList.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval != null){
            resultList.add(newInterval);
        }
        int[][] resultArray = new int[resultList.size()][2];
        for(int i = 0; i < resultList.size(); i++){
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }
}
