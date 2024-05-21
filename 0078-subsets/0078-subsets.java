class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0;i<1<<nums.length;++i) {
            res.add(new ArrayList<Integer>());
            for (int b=0;b<nums.length;++b) {
                if(((i>>b) & 1)==1){
                    res.get(i).add(nums[b]);
                }
            }
        }
        return res;
    }
}