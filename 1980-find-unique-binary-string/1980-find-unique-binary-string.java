class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int n = nums[0].length();
        int maxNum = 1 << n;
        for (int i = len - 1; i >= 0 && maxNum-- >= 0; i--) {
            if (binaryToInt(nums[i]) != maxNum) {
                return intToBinary(maxNum);
            }
        }
        return "";
    }

    private int binaryToInt(String n) {
        int res = 0;
        for (char c : n.toCharArray()) {
            res = res * 2 + (c - '0');
        }
        return res;
    }

    private String intToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n & 1);
            n = n >> 1;
        }
        return sb.reverse().toString();
    }
}