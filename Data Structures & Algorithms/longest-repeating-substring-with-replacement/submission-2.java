class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        Map<Character,Integer> countMap = new HashMap<>();
        int maxLength = 0, maxFrquency = 0;
        while(right < s.length()){
            char cur = s.charAt(right);
            countMap.put(cur, countMap.getOrDefault(cur,0)+1);
            maxFrquency = Math.max(maxFrquency, countMap.get(cur));
            while((right-left+1)-maxFrquency > k){
                char leftChar = s.charAt(left);
                countMap.put(leftChar, countMap.get(leftChar)-1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }

    public int maxFequency(Collection<Integer> values){
        int max = Integer.MIN_VALUE;
        for(int val : values){
            max = Math.max(val,max);
        }
        return max;
    }
}
