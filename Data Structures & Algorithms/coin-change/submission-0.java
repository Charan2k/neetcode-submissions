class Solution {
    int dp[];
    private int solve(int index, int amount, int coins[]) {
        if(index < 0) {
            if(amount == 0) return 0;
            return (int)1e9;
        }
        if(dp[amount] != -1) return dp[amount];
        int take = (int)1e9;
        if(amount >= coins[index]) take = 1 + solve(index, amount-coins[index], coins);
        int nottake = solve(index-1, amount, coins);

        return dp[amount] = Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int ans = solve(n-1, amount, coins);
        if(ans == (int)1e9) return -1;
        return ans;
    }
}
