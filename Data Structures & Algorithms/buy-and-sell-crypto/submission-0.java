class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int curr = prices[0];
        int ans = 0;
        for(int i=1; i<n; i++) {
            if(prices[i] < curr) {
                curr = prices[i];
            }
            else ans = Math.max(ans, prices[i] - curr);
        }

        return ans;

    }
}
