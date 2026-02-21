class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int num=setBits(i);
            if(isPrime(num)) ans++;
        }
        return ans;
    }

    private int setBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    private boolean isPrime(int n) {
        // Check if n is 1 or 0
        if (n <= 1)
            return false;
        // Check if n is 2 or 3
        if (n == 2 || n == 3)
            return true;
        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i *i<=n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
}