class Solution {
    public int trap(int[] heights) {
        int n = heights.length;

        int prefMax[] = new int[n];
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            maxi = Math.max(maxi, heights[i]);
            prefMax[i] = maxi;
        }

        int suffMax[] = new int[n];
        maxi = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--) {
            maxi = Math.max(maxi, heights[i]);
            suffMax[i] = maxi;
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += (Math.min(prefMax[i], suffMax[i])) - heights[i];
        }

        return ans;
    }
}
