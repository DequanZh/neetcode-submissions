class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, down = matrix.length-1;
        int m = matrix.length, n = matrix[0].length;
        while(top <= down){
            int mid = top + (down-top)/2;
            if(matrix[mid][0] < target){
                top = mid + 1;
            }else{
                down = mid - 1;
            }
            // in this range
            int left = 0, right = n;
            while(left < right){
                int rowMid = left + (right-left)/2;
                if(matrix[mid][rowMid] == target){
                    return true;
                }
                if(matrix[mid][rowMid] >= target){
                    right = rowMid;
                }else{
                    left = rowMid + 1;
                }
            }
        }
        return false;
    }
}
