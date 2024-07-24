class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "num: "+this.x + " | idx: " + this.y;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair(convertNum(nums[i], mapping), i));
        }
        // System.out.println(list);
        Collections.sort(list, (Pair a, Pair b) -> a.x == b.x ? a.y - b.y : a.x - b.x);
        // System.out.println(list);
        // System.out.println(mp);
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = list.get(i).y;
            res[i] = nums[idx];
        }
        return res;
    }

    private int convertNum(int num, int[] map) {
        int newNum = 0;
        int placeVal = 1;
        if(num==0) return map[0];
        while (num > 0) {
            int lastDig = num % 10;
            newNum += map[lastDig] * placeVal;
            placeVal *= 10;
            num /= 10;
        }
        return newNum;
    }
}