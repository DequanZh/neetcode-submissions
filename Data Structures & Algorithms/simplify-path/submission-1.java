class Solution {
    public String simplifyPath(String path) {
        String[] dic = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String d : dic){
            if(d.equals(".") || d.trim().length() == 0){
                continue;
            }
            if(d.equals("..")){
                if(stack.size() > 0){
                    stack.removeLast();
                }
                continue;
            }
            stack.addLast(d);
        }
        return "/"+String.join("/",stack);
    }
}