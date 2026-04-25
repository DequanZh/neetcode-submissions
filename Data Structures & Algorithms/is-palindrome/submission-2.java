class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right){
            while(left < s.length()-1 && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(right > 0 && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) &&
            Character.isLetterOrDigit(s.charAt(right)) && Character.isLetterOrDigit(s.charAt(left))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
