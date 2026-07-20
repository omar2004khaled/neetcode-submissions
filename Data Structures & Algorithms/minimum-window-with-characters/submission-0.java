class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // Count characters needed from t
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> win = new HashMap<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int have = 0, needCount = need.size();
        int left = 0, start = 0, min = Integer.MAX_VALUE;

        // Expand the window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && win.get(c).equals(need.get(c)))
                have++;

            // Shrink while the window is valid
            while (have == needCount) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                char ch = s.charAt(left);
                win.put(ch, win.get(ch) - 1);

                if (need.containsKey(ch) && win.get(ch) < need.get(ch))
                    have--;

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}