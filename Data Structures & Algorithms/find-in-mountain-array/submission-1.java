/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 1, right = mountainArr.length()-2;
        int pivot = 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int pre = mountainArr.get(mid-1), cur = mountainArr.get(mid), nxt = mountainArr.get(mid+1);
            if(pre < cur && cur < nxt){ // left portion
                left = mid+1;
            }else if(pre > cur && cur > nxt){// right portion
                right = mid-1;
            }else{
                pivot = mid;
                break;
            }
        }
        left = 0;
        right = pivot-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            if(midVal > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        left = pivot;
        right = mountainArr.length()-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }
            if(midVal < target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}