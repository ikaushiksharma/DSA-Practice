class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : arr2)
            mp.put(i, 0);
        int last = arr1.length - 1;
        int res[] = new int[arr1.length];
        for (int i : arr1) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                res[last--] = i;
            }
        }
        int i = 0;
        for (int num : arr2) {
            int cnt=mp.get(num);
            while(cnt-- >0){
                res[i++]=num;
            }
        }
        Arrays.sort(res,i,arr1.length);
        return res;
    }
}