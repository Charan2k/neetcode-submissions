class Solution {
    private boolean canEat(int piles[], int k, int h) {
        int n = piles.length;
        int hours = 0;
        for(int i=0; i<n; i++) {
            hours += (piles[i]/k + (piles[i]%k==0? 0: 1));
        }

        return hours <= h;
    }
    private int min(int arr[]) {
        int ans = Integer.MAX_VALUE;

        for(int a: arr) ans = Math.min(ans, a);
        return ans;
    }

    private int max(int arr[]) {
        int ans = Integer.MIN_VALUE;

        for(int a: arr) ans = Math.max(ans, a);
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canEat(piles, mid, h)) {
                high = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                low = mid + 1;
            }
        }
        return ans;

    }
}
