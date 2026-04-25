class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if("({[".contains(String.valueOf(c))){
                stack.addLast(c);
            }else{
                if(stack.size() == 0){
                    return false;
                }
                if(!"(){}[]".contains(String.valueOf(stack.peekLast())+String.valueOf(c))){
                    return false;
                }
                stack.removeLast();
            }
        }
        return stack.size() == 0;
    }
}
