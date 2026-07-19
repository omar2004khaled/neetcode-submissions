class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                int last = stack.pop();
                int sum = last + stack.peek();
                stack.push(last);
                stack.push(sum);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int ans = 0;
        while (!stack.isEmpty())
            ans += stack.pop();

        return ans;
    }
}