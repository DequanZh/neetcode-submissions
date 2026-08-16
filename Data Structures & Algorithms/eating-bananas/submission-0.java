class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for(int pile : piles){
            right = Math.max(right,pile);
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canEat(piles,mid,h)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right+1;
    }

    public boolean canEat(int[] piles, int k, int h){
        int curEat = 0;
        for(int pile : piles){
            curEat += Math.ceil((double) pile / k);
        }
        return curEat <= h;
    }
}
