class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int curr = getIntersectingSide(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]);
                res = Math.max(curr, res);
            }
        }
        return (long) res * res;
    }

    private int getIntersectingSide(int xBottom[], int xTop[], int yBottom[], int yTop[]) {
        int minX = Math.max(xBottom[0], yBottom[0]);
        int maxX = Math.min(xTop[0], yTop[0]);
        int minY = Math.max(xBottom[1], yBottom[1]);
        int maxY = Math.min(xTop[1], yTop[1]);

        if (minX < maxX && minY < maxY) {
            return Math.min(maxX - minX, maxY - minY);
        }
        return 0;

    }

}