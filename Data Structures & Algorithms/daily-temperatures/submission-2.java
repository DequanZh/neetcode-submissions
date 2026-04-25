class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> monoStack = new LinkedList<>();
        for(int i = temperatures.length-1; i >= 0; i--){
            while(monoStack.size() > 0 && temperatures[monoStack.peekLast()] <= temperatures[i]){
                monoStack.removeLast();
            }
            result[i] = monoStack.size() == 0 ? 0 : monoStack.peekLast()-i;
            monoStack.addLast(i);
        }
        return result;
    }
}
