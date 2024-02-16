class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, res, 0, candidates.length, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] arr, List<List<Integer>> res, int idx, int n, int target, ArrayList<Integer> ds) {
        if (idx == n) {
            if (target == 0) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            helper(arr, res, idx, n, target - arr[idx], ds);
            ds.remove(ds.size() - 1);
        }

        helper(arr, res, idx + 1, n, target, ds);
    }
}