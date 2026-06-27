class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int num: nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] < 0) return Math.abs(num);

            nums[index] = -nums[index];
        }

        return -1;

    }
}
