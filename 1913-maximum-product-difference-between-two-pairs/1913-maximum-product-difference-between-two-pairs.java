class Solution {
    public int maxProductDifference(int[] nums) {
        int max=Integer.MIN_VALUE, max1=Integer.MIN_VALUE, min=Integer.MAX_VALUE, min1=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= max) {
                max1 = max;
                max = num;
            } else if (num > max1)
                max1 = num;

            if (num <= min) {
                min1 = min;
                min = num;
            } else if (num < min1)
                min1 = num;
        }
        return (max * max1) - (min * min1);
    }
}