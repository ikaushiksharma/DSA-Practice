class Solution {
    public int maximumLength(String s) {
        int minRange = 1;
        int maxRange = s.length() - 2;
        int length = -1;

        for (int i = minRange; i <= maxRange; i++) {
            HashMap<String, Integer> record = new HashMap<>();
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, j + i);
                record.put(sub, record.getOrDefault(sub, 0) + 1);
            }
            for (String key : record.keySet()) {
                if (record.get(key) >= 3) length = i;
            }
        }

        return length;
    }
}