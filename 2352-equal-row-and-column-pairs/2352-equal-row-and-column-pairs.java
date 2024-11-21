class Solution {
  public int equalPairs(int[][] grid) {
    int n = grid.length;
    HashMap<String, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String row = Arrays.toString(grid[i]);
      mp.put(row, mp.getOrDefault(row, 0) + 1);
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      int arr[] = new int[n];
      for (int j = 0; j < n; j++)
        arr[j] = grid[j][i];
      String col = Arrays.toString(arr);
      res += mp.getOrDefault(col, 0);
    }

    return res;
  }
}