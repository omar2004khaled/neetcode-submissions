class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // First smaller on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // First smaller on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        int max = 0;

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }

        return max;
    }
}