class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0, candidates, target, ans, new ArrayList<Integer>());
        return ans;
    }

    public void combination(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;
            ds.add(candidates[i]);
            combination(i + 1, candidates, target - candidates[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}