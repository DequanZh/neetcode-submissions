class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals,(i1,i2)->{
            return i1[0]-i2[0];
        });
        resultList.add(intervals[0]);
        int i = 1;
        while(i < intervals.length){
            int[] prv = resultList.get(resultList.size()-1);
            int[] cur = intervals[i];
            if(cur[0] <= prv[1]){
                resultList.set(resultList.size()-1, new int[]{
                    Math.min(prv[0],cur[0]),
                    Math.max(prv[1],cur[1])
                });
            }else{
                resultList.add(cur);
            }
            i++;
        }
        return resultList.toArray(new int[resultList.size()][2]);
    }
}
