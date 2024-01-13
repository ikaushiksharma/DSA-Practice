class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int res=s.length();
        for(char c:s.toCharArray()) mp.put(c,mp.getOrDefault(c,0)+1);
        for(char c:t.toCharArray()){
            if(mp.containsKey(c)){
                res--;
                mp.put(c,mp.getOrDefault(c,0)-1);
                if(mp.get(c)==0){
                    mp.remove(c);
                }
            }
        }
        return res;
    }
}