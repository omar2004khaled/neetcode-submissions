class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int i = 0;

        while (i < n - 1) {

            while (i < n - 1 && prices[i] >= prices[i + 1])
                i++;

            int min = prices[i];

            while (i < n - 1 && prices[i] <= prices[i + 1])
                i++;

            int max = prices[i];

            profit += max - min;
        }

        return profit;
    }
}