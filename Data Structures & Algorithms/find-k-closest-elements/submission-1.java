
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        // Find insertion position of x
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Two pointers around x
        int l = right;
        int r = left;

        while (k > 0) {
            if (l < 0) {
                r++;
            } else if (r >= n) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
            k--;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = l + 1; i < r; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}