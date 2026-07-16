class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,List<Pair<Integer,Double>>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjMap.put(i,new ArrayList<Pair<Integer,Double>>());
        }
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];

            List<Pair<Integer,Double>> fromChilds = adjMap.get(from);
            fromChilds.add(new Pair<Integer,Double>(to, prob));
            List<Pair<Integer,Double>> toChilds = adjMap.get(to);
            toChilds.add(new Pair<Integer,Double>(from, prob));
        }
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>(
            (p1,p2) -> {return Double.compare(p2.getValue(),p1.getValue());}
        );

        pq.add(new Pair<Integer, Double>(start_node, 1.0));
        double[] maxProb = new double[n];
        while(pq.size() > 0){
            Pair<Integer, Double> curPair = pq.poll();
            int curNode = curPair.getKey();
            double curProb = curPair.getValue();
            if(curNode == end_node){
                return curProb;
            }
            if(curProb < maxProb[curNode]) continue;
            for(Pair<Integer,Double> child : adjMap.get(curNode)){
                double newProb = child.getValue()*curProb;
                if(newProb > maxProb[child.getKey()]){
                    maxProb[child.getKey()] = newProb;
                    pq.add(new Pair<Integer,Double>(child.getKey(),newProb));
                }
            }
        }

        return 0;
    }
}