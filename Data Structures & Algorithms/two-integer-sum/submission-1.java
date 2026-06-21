class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int targetKey = target - nums[i];
            if(map.get(targetKey) != null) {
                return new int[]{map.get(targetKey),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
