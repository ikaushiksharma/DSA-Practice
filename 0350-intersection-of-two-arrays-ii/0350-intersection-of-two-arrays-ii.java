class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (mp.containsKey(nums1[i]))
                mp.put(nums1[i], mp.get(nums1[i]) + 1);
            else
                mp.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (mp.containsKey(nums2[i]) && (mp.get(nums2[i]) > 0)) {
                res.add(nums2[i]);
                mp.put(nums2[i], mp.get(nums2[i]) - 1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }
}