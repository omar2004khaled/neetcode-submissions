class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (freq[c] > 0) {
                freq[s.charAt(left)]--;
                left++;
            }

            freq[c]++;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}