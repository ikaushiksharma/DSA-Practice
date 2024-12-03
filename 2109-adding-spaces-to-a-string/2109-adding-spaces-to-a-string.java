class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int currIdx=0;
        for(int i:spaces){
            sb.append(s.substring(currIdx,i));
            currIdx=i;
            sb.append(" ");
        }
        sb.append(s.substring(currIdx));
        return sb.toString();
    }
}