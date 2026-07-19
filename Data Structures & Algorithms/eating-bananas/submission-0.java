class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // ceil(pile / mid)
            }

            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}