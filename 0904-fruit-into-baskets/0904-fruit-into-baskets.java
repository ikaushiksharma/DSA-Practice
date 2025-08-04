class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < fruits.length; right++) {
            mp.put(fruits[right], mp.getOrDefault(fruits[right], 0) + 1);
            while (mp.size() > 2) {
                mp.put(fruits[left], mp.get(fruits[left]) - 1);
                if (mp.get(fruits[left]) == 0)
                    mp.remove(fruits[left]);
                left++;
            }
            res = Math.max(res, getSumOfFrequencies(mp));
        }
        return res;
    }

    private int getSumOfFrequencies(HashMap<Integer, Integer> mp) {
        int res = 0;
        for (int cnt : mp.values())
            res += cnt;
        return res;
    }
}