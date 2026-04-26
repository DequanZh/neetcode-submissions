class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid : asteroids){
            boolean alive = true;
            while(alive && stack.size() > 0 && stack.peekLast() > 0 && asteroid < 0){
                if(stack.peekLast() < -asteroid){
                    stack.removeLast();
                }else if(stack.peekLast() == -asteroid){
                    stack.removeLast();
                    alive = false;
                }else{
                    alive = false;
                }
            }
            if(alive){
                stack.addLast(asteroid);
            }
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