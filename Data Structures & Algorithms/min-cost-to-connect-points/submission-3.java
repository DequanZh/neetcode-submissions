class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] distance = new int[points.length];
        boolean[] visted = new boolean[points.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int curNode = 0;
        int edges = 0;
        int totalCost = 0;
        while(edges < points.length-1){
            visted[curNode] = true;
            int nextNode = -1;
            for(int i = 0; i < points.length; i++){
                if(visted[i]) continue;
                int curDistance = Math.abs(points[curNode][0] - points[i][0]) + Math.abs(points[curNode][1] - points[i][1]);
                distance[i] = Math.min(distance[i], curDistance);
                if(nextNode == -1 || distance[nextNode] > distance[i]){
                    nextNode = i;
                }
            }
            totalCost += distance[nextNode];
            curNode = nextNode;
            edges++;
        }
        return totalCost;
    }
}
