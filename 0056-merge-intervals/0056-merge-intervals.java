class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { intervals[0][0], intervals[0][1] });
        int lastIndex = 0;

        for (int i = 0; i < intervals.length; i++) {
            int end = list.get(lastIndex)[1];
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                list.set(lastIndex, new int[] { list.get(lastIndex)[0], end });
            } else {
                list.add(new int[] { intervals[i][0], intervals[i][1] });
                lastIndex++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}