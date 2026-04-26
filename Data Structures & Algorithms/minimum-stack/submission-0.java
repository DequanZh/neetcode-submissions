class MinStack {
    class StackEntry {
        int val;
        int min;
    }

    Deque<StackEntry> stack = new LinkedList<>();
    int globalMin = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        StackEntry entry = new StackEntry();
        entry.val = val;
        entry.min = globalMin;
        globalMin = Math.min(globalMin,val);
        stack.addLast(entry);
    }
    
    public void pop() {
        StackEntry entry = stack.removeLast();
        globalMin = entry.min;
    }
    
    public int top() {
        return stack.peekLast().val;
    }
    
    public int getMin() {
        return globalMin;
    }
}
