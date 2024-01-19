class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> out) {
        if (out.size() == nums.length) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (out.contains(nums[i]))
                continue;
            out.add(nums[i]);
            helper(nums, res, out);
            out.remove(out.size() - 1);
        }
    }
}