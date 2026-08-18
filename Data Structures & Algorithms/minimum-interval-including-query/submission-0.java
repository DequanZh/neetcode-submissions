class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (i1,i2) -> {return i1[0]-i2[0];});
        //[i,queries[i]]
        List<int[]> queryList = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            queryList.add(new int[]{i, queries[i]});
        }
        Collections.sort(queryList, (q1,q2)->{
            return q1[1] - q2[1];
        });
        int[] result = new int[queries.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2)->{
            int length1 = i1[1] - i1[0] + 1;
            int length2 = i2[1] - i2[0] + 1;
            return length1 - length2;
        });
        int j = 0;
        for(int i = 0; i < queryList.size(); i++){
            int[] curPair = queryList.get(i);
            int queryIndex = curPair[0], queryLength = curPair[1];
            while(j < intervals.length && intervals[j][0] <= queryLength){
                pq.offer(intervals[j]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < queryLength){
                pq.poll();
            }
            if(pq.isEmpty()){
                result[queryIndex] = -1;
            }else{
                int length = pq.peek()[1] - pq.peek()[0] + 1;
                result[queryIndex] = length;
            }
        }
        return result;
    }
}
