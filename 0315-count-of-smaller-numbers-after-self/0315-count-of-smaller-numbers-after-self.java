class Solution {
    List<Integer> list= new ArrayList<>();


    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] = bs(nums[i], 0, list.size());
        }
        List ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            ans.add(arr[i]);

        return ans;
    }

    public int bs(int x, int s, int h) {
        int mid = s + (h - s) / 2;
        if (s >= h) {
            list.add(mid, x);
            return mid;
        }
        if (x <= list.get(mid)) {
            return bs(x, s, mid);
        } else {
            return bs(x, mid + 1, h);
        }
    }
}