class StockSpanner {
    private Deque<Integer> stack1; // main stack
    private Deque<Integer> stack2; // temporary holding stack

    public StockSpanner() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int count = 0;
        
        // pop all prices <= current price into stack2, counting them
        while (!stack1.isEmpty() && stack1.peek() <= price) {
            stack2.push(stack1.pop());
            count++;
        }
        
        // restore stack1 by pushing back from stack2
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        
        stack1.push(price);
        return count + 1;
    }
}