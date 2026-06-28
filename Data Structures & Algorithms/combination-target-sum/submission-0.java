class Solution {
    List<List<Integer>> res;
    private void solve(int index, int nums[], List<Integer> curr, int target) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(index < 0) return;

        curr.add(nums[index]);
        solve(index, nums, curr, target - nums[index]);
        curr.remove(curr.size()-1);
        solve(index-1, nums, curr, target);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        solve(n-1, nums, curr, target);
        return res;
    }
}
