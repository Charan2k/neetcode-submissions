class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int prefProd[] = new int[n];
        int suffProd[] = new int[n];
        prefProd[0] = 1;
        suffProd[n-1] = 1;
        for(int i=0; i<n; i++) {
            if(i!=0) {
                prefProd[i] = prefProd[i-1] * nums[i-1];
                suffProd[n-i-1] = suffProd[n-i] * nums[n-i];
            }
        }

        int ans[] = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = prefProd[i] * suffProd[i];
        }

        return ans;
    }
}  
