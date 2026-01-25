class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (valueToIndex.containsKey(target - num)) {
                return new int[] { valueToIndex.get(target - num), i };
            }
            valueToIndex.put(num, i);
        }
        return new int[] { -1, -1 };
    }
}