class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            } else if (i < minutes)
                temp += customers[i];
        }
        System.out.println(sum);
        int left = 0;
        int max = sum + temp;
        int res = max;
        for (int right = minutes; right < n; right++, left++) {
            if (grumpy[left] == 0) {
                max -= customers[left];
            }
            if (grumpy[right] == 0)
                max += customers[right];
            res = Math.max(res, max);
        }
        return res;
    }
}