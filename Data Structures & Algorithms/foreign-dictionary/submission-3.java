class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> adjMap = new HashMap<>();
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                adjMap.put(word.charAt(i), new HashSet<>());
            }
        }
        for(int i = 0; i < words.length-1; i++){
            String cur = words[i], next = words[i+1];
            if(cur.length() > next.length() && cur.startsWith(next)){
                return "";
            }
            for(int j = 0; j < Math.min(cur.length(),next.length()); j++){
                if(cur.charAt(j) != next.charAt(j)){
                    adjMap.get(next.charAt(j)).add(cur.charAt(j));
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        Map<Character,Boolean> vistedMap = new HashMap<>();
        for(char c : adjMap.keySet()){
            if(dfs(adjMap,c,result,vistedMap)){
                return "";
            }
        }
        return result.toString();
    }

    public boolean dfs(Map<Character,Set<Character>> adjMap, char cur,  StringBuilder result, Map<Character,Boolean> vistedMap){
        if(vistedMap.containsKey(cur)){
            return vistedMap.get(cur);
        }
        vistedMap.put(cur,true);
        for(char next : adjMap.get(cur)){
            if(dfs(adjMap,next,result,vistedMap)){
                return true;
            }
        }
        vistedMap.put(cur,false);
        result.append(cur);
        return false;
    }
}
