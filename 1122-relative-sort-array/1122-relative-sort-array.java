   class Solution{
public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> m = new HashMap();
        for (int num : arr2) {
            m.put(num, 0);
        }
        int last = arr1.length - 1;
        int[] res = new int[arr1.length];
        for (int num : arr1) {
            if (m.containsKey(num))
                m.put(num, m.get(num) + 1);
            else {
                res[last--] = num;
            }
        }
        int p = 0;
        for (int num : arr2) {
            int c = m.get(num);
            for (int i = 0; i < c; i++) {
                res[p++] = num;
            }
        }
        Arrays.sort(res, p, res.length);
        return res;
    }
   }