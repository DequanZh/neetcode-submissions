class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2)->{
            return i1[0] - i2[0];
        });
        int[] curInterval = intervals[0];
        int removed = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            // merge them;
            if(interval[0] < curInterval[1]){
                curInterval = new int[]{curInterval[0], Math.min(interval[1],curInterval[1])};
                removed++;
            }else{
                curInterval = interval;
            }
        }
        return removed;
    }
}
