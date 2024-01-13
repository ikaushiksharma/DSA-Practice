class Solution {
    final static int a = 97; //ASCII OF 'a'
    final static int size = 26; //size of array
	
    public int minSteps(String s, String t) {
        int[] arr = new int[size];
        int l = s.length();
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < l; i++) {
            int sci = sa[i] - a;
            int tci = ta[i] - a;
            arr[sci] += 1;
            arr[tci] -= 1;
        }
        int ans = 0;
        for (int n : arr) {
            if (n > 0) {
                ans += n;
            }
        }
        return ans;
    }
}