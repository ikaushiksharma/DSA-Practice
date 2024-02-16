class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,new ArrayList<>(),res);
        return res;
    }
    private void helper(int []nums,ArrayList<Integer> ds,List<List<Integer>> res){
        if(ds.size()==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(ds.contains(nums[i])) continue;
            ds.add(nums[i]);
            helper(nums,ds,res);
            ds.remove(ds.size()-1);
        }
    }
}