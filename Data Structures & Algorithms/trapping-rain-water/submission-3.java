class Solution {
    public int trap(int[] heights) {
        int n = heights.length;

        int left = 0;
        int right = n - 1;
        int ans = 0;
        int leftMaxi = -1;
        int rightMaxi = -1;
        while(left < right) {
            leftMaxi = Math.max(leftMaxi, heights[left]);
            rightMaxi = Math.max(rightMaxi, heights[right]);

            if(leftMaxi < rightMaxi) {
                ans += leftMaxi - heights[left];
                left++;
            }
            else {
                ans += rightMaxi - heights[right];
                right--;
            }
        }

        return ans;
    }
}
