class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        HashSet<Integer> set = new HashSet();
        for (int uniqElement : arr) {

            if (map.containsKey(uniqElement))
                map.put(uniqElement, map.get(uniqElement) + 1);
            else
                map.put(uniqElement, 1);
        }
        for (int element : map.values())
            set.add(element);
        return set.size() == map.size();
    }
}