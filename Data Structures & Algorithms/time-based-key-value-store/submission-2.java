class TimeMap {
    Map<String,List<Pair<String,Integer>>> timeMap = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String,Integer>> curList = timeMap.get(key);
        if(curList == null){
            return "";
        }
        int left = 0, right = curList.size()-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            Pair<String,Integer> curPair = curList.get(mid);
            if(curPair.getValue() > timestamp){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(right < 0){
            return "";
        }
        return curList.get(right).getKey();
    }
}
