class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty()) {

                int prev = stack.peek();

                if (temperatures[i] > temperatures[prev]) {
                    stack.pop();
                    ans[prev] = i - prev;
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        return ans;
    }
}