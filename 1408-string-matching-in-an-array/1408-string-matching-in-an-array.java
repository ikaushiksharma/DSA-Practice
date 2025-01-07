class Solution {
    public List<String> stringMatching(String[] words) {
        // Arrays.sort(words);
        Arrays.sort(words,(a,b)->a.length()-b.length());
        System.out.println(Arrays.toString(words));
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}