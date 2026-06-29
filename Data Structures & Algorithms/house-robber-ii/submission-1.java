class Solution {
    private int solve(int index, int n, int nums[], int dp[]) {
        if(index >= n) return 0;
        if(dp[index] != -1) return dp[index];
        dp[index] = nums[index] + solve(index+2, n, nums, dp);
        return dp[index] = Math.max(dp[index], solve(index+1, n, nums, dp));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int first = solve(0, n-1, nums, dp);

        Arrays.fill(dp, -1);
        int second = solve(1, n, nums, dp);

        return Math.max(first, second);
    }
}
