class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> charSet = new HashSet();
        for(char c : s.toCharArray()){
            while(charSet.contains(c)){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(c);
            maxLength = Math.max(maxLength, charSet.size());
        }
        return maxLength;
    }
}
