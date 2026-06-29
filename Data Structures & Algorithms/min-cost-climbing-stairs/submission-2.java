class Solution {
    private int solve(int index, int n, int cost[], int dp[]) {
        if(index >= n) return 0;
        if(dp[index] != -1) return dp[index];

        return dp[index] = cost[index] + 
            Math.min(solve(index+1, n, cost, dp), solve(index+2, n, cost, dp));

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<=n; i++) {
            if(i == n) dp[i] = Math.min(dp[i-1], dp[i-2]);
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return dp[n];

        // Arrays.fill(dp, -1);
        // int fromZero = solve(0, n, cost, dp);

        // Arrays.fill(dp, -1);
        // int fromOne = solve(1, n, cost, dp);

        // return Math.min(fromZero, fromOne);
    }
}
