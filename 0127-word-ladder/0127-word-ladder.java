class Solution {
    class Pair {
        String s;
        int step;

        Pair(String s, int step) {
            this.s = s;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>();
        for (String s : wordList)
            set.add(s);
        set.remove(beginWord);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.s;
            int step = p.step;
            if (word.equals(endWord) == true)
                return step;
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char wordArray[] = word.toCharArray();
                    wordArray[i] = c;
                    String replacedString = new String(wordArray);
                    if (set.contains(replacedString)) {
                        set.remove(replacedString);
                        q.add(new Pair(replacedString, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}