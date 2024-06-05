class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result=new ArrayList<>();
        for(char c='a';c<='z';c++)
        {
            int mincount=Integer.MAX_VALUE;
            for(String word:words)
            {
                int wordcount=0;
                for (char cur_c : word.toCharArray()) if (cur_c == c) wordcount++;
                mincount=Math.min(mincount,wordcount);
            }
            for (int i = 0; i < mincount; i++) result.add("" + c);
        }    
    return result;
    }
}