class FreqStack {

    Stack<Integer> stack;
    HashMap<Integer, Integer> freq;

    public FreqStack() {
        stack = new Stack<>();
        freq = new HashMap<>();
    }

    public void push(int val) {
        stack.push(val);
        freq.put(val, freq.getOrDefault(val, 0) + 1);
    }

    public int pop() {
        int maxFreq = 0;

        for (int num : freq.keySet()) {
            maxFreq = Math.max(maxFreq, freq.get(num));
        }

        Stack<Integer> temp = new Stack<>();
        int ans = -1;

        while (!stack.isEmpty()) {
            int x = stack.pop();

            if (freq.get(x) == maxFreq) {
                ans = x;
                freq.put(x, freq.get(x) - 1);
                break;
            }

            temp.push(x);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return ans;
    }
}