class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for(int asteroid : asteroids){
            if(asteroid > 0 || (stack.size() > 0 && stack.peekLast() < 0)){
                stack.addLast(asteroid);
                continue;
            }
            while(stack.size() > 0 && stack.peekLast() < Math.abs(asteroid) && stack.peekLast() > 0){
                stack.removeLast();
            }
            if(stack.size() > 0 && stack.peekLast() >= Math.abs(asteroid) && stack.peekLast() > 0){
                if(stack.peekLast() == Math.abs(asteroid)){
                    stack.removeLast();
                }
                continue;
            }
            stack.addLast(asteroid);
        }
        int[] stackArray = new int[stack.size()];
        int j = 0;
        while(stack.size() > 0){
            stackArray[j] = stack.removeFirst();
            j++;
        }
        return stackArray;
    }
}