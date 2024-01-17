///TC - O(NlogN) SC - O(N)
class Solution {
    class Pair {
        int diff;
        int prof;

        Pair(int diff, int prof) {
            this.diff = diff;
            this.prof = prof;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;

        Pair[] combine = new Pair[n];

        for (int i = 0; i < n; i++) {
            Pair p = new Pair(difficulty[i], profit[i]);
            combine[i] = p;
        }

        Arrays.sort(combine, (a, b) -> Integer.compare(a.diff, b.diff));

        Arrays.sort(worker);

        int i = 0, j = 0, totalP = 0, prev = 0;

        while (i < worker.length) {

            while (j < n) {
                int d = combine[j].diff;
                int p = combine[j].prof;
                // WE GOT A JOB , SAVE IT AND LOOK FOR BETTER JOB
                if (d <= worker[i]) {
                    prev = Math.max(p, prev);
                }
                /// IF JOB DIFFICULTY IS GREATER NO NEED TO GO FURTHER , WILL BREAK
                if (d > worker[i]) {
                    break;
                }
                j++;
            }
            /// KEEP ON ADDING PROFITS HERE
            totalP += prev;
            i++;
        }

        /// RETURN
        return totalP;

    }
}