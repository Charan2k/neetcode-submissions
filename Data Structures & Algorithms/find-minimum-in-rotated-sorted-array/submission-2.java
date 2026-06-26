class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mini = nums[0];
        while(low <= high) {

            if(nums[low] < nums[high]) {
                mini = Math.min(mini, nums[low]);
                break;
            }

            int mid = low + (high - low) / 2;
            mini = Math.min(mini, nums[mid]);
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return mini;
    }
}
