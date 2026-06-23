class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<n-2; i++) {
            int first = i + 1;
            int last = n - 1;
            int target = -nums[i];
            while(first < last) {
                int sum = nums[first] + nums[last];
                if(sum == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[first], nums[last])));

                    int curr = nums[first];
                    while(first < last && nums[first] == curr) {
                        first++;
                    }

                    curr = nums[last];
                    while(last > first && nums[last] == curr) {
                        last--;
                    }
                }
                else if(sum < target) first++;
                else last--;
            }
        }
        return new ArrayList<>(ans);
    }
}
