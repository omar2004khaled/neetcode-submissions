class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int water = 0;

        while (left < n - 1) {
            int right = left + 1;
            int highest = right;

            while (right < n && height[right] < height[left]) {
                if (height[right] > height[highest])
                    highest = right;
                right++;
            }

            if (right == n)
                right = highest;

            int level = Math.min(height[left], height[right]);

            for (int i = left + 1; i < right; i++)
                water += level - height[i];

            left = right;
        }

        return water;
    }
}