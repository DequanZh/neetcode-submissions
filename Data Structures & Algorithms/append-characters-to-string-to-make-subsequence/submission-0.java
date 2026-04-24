class Solution {
    public int appendCharacters(String s, String t) {
        int sptr = 0, tptr = 0;
        while(tptr < t.length() && sptr < s.length()){
            if(s.charAt(sptr) == t.charAt(tptr)){
                tptr++;
            }
            sptr++;
        }
        return Math.max(0,t.length()-tptr);
    }
}