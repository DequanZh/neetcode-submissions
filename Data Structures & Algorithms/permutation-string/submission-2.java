class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character, Integer> s1Count = new HashMap<>(), s2Count = new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Count.put(c,s1Count.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0;
        while(right < s2.length()){
            s2Count.put(s2.charAt(right),s2Count.getOrDefault(s2.charAt(right),0)+1);
            if((right-left+1) > s1.length()){
                s2Count.put(s2.charAt(left),s2Count.getOrDefault(s2.charAt(left),0)-1);
                left++;
            }
            if(equal(s1Count,s2Count)){
                return true;
            }
            right++;
        }
        return false;
    }

    public boolean equal(Map<Character, Integer> s1Count, Map<Character, Integer> s2Count){
        for(Character c: s1Count.keySet()){
            if(s2Count.get(c) == null || s2Count.get(c) != s1Count.get(c)){
                return false;
            }
        }
        return true;
    }
}
