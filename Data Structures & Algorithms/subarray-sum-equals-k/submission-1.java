class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int count = 0;

        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int sum;

                if (l == 0) {
                    sum = prefix[r];
                } else {
                    sum = prefix[r] - prefix[l - 1];
                }

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}