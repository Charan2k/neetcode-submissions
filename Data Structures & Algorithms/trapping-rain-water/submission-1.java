class Solution {
    public int trap(int[] heights) {
        int n = heights.length;

        int suffMax[] = new int[n];
        int maxi = -1;
        for(int i=n-1; i>=0; i--) {
            maxi = Math.max(maxi, heights[i]);
            suffMax[i] = maxi;
        }

        maxi = -1;
        int ans = 0;
        for(int i=0; i<n; i++) {
            maxi = Math.max(maxi, heights[i]);
            ans += (Math.min(maxi, suffMax[i]) - heights[i]);
        }

        return ans;
    }
}
