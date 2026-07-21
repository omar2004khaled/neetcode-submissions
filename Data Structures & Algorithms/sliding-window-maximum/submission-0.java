class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]   // Max heap by value
        );

        int[] ans = new int[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums[i], i});
        }

        ans[0] = heap.peek()[0];

        int left = 1;

        // Slide the window
        for (int right = k; right < nums.length; right++) {
            heap.offer(new int[]{nums[right], right});

            // Remove elements outside the window
            while (heap.peek()[1] < left) {
                heap.poll();
            }

            ans[left] = heap.peek()[0];
            left++;
        }

        return ans;
    }
}