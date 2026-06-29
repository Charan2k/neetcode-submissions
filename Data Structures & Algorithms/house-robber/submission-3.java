class Solution {
    private int solve(int index, int nums[], int dp[]) {
        if(index < 0) return 0;
        int take = nums[index] + solve(index-2, nums, dp);
        int nottake = solve(index-1, nums, dp);

        return Math.max(take, nottake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int dp[] = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return Math.max(dp[n-1], dp[n-2]);


    }
}
