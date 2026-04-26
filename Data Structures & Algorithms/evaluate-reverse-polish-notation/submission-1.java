class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token : tokens){
            if("+-/*".contains(token)){
                int a = stack.removeLast();
                int b = stack.removeLast();
                if(token.equals("+")){
                    stack.addLast(a+b);
                }
                if(token.equals("-")){
                    stack.addLast(b-a);
                }
                if(token.equals("*")){
                    stack.addLast(a*b);
                }
                if(token.equals("/")){
                    stack.addLast(b/a);
                }
            }else{
                stack.addLast(Integer.valueOf(token));
            }
        }
        return stack.removeLast();
    }
}
