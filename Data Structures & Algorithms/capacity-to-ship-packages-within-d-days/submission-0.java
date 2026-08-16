class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0], right = 0;
        for(int weight : weights){
            left = Math.max(left,weight);
            right += weight;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canShip(weights,mid,days)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right+1;
    }

    public boolean canShip(int[] weights, int maxWeight, int days){
        int takeDay = 1;
        int curWeight = 0;
        for(int weight : weights){
            if(curWeight + weight <= maxWeight){
                curWeight += weight;
            }else{
                takeDay++;
                curWeight = weight;
            }
        }
        return days >= takeDay;
    }
}