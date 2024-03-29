class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        boolean xx = true;
        boolean yy = true;
        for (int i = 0; i < x.length && (xx || yy); i++) {
            if (x[i] < y[i])
                xx = false;
            if (y[i] < x[i])
                yy = false;
        }
        return xx || yy;

    }
}