class Solution {
    private int solve(int index, int nums[], int dp[]) {
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int res = 1;
        for(int j=index-1; j>=0; j--) {
            if(nums[j] < nums[index]) {
                res = Math.max(res, 1+ solve(j, nums, dp));
            }
        }
        return dp[index] = res;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1);
        int ans = 0;
        for(int i=n-1; i>=0; i--) {
            ans = Math.max(ans, solve(i, nums, dp));
        }
        return ans;
    }
}
