class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length-1;
        while((right - left + 1) > k){
            int diffLeft = Math.abs(arr[left]-x);
            int diffRight = Math.abs(arr[right]-x);
            if(diffRight >= diffLeft){
                right--;
            }else{
                left++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }
        return result;
    }
}