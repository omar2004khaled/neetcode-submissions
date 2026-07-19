class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int one = 0;
        int two = n - 1;

        while (one < two) {
            max = Math.max(max, (two - one) * Math.min(heights[one], heights[two]));

            if (heights[one] < heights[two])
                one++;
            else
                two--;
        }

        return max;
    }
}