class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Collections.sort(dictionary);
        // System.out.println(Arrays.toString(words));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            for (String dic : dictionary)
                if (words[i].startsWith(dic)) {
                    words[i] = dic;
                    break;
                }

        }
        return String.join(" ", words);
    }
}