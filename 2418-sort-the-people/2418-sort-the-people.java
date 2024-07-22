class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=names.length;
        HashMap<Integer,String> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for(int i=0;i<n;i++){
            names[i]=mp.get(heights[n-i-1]);
        }
        return names;
    }
}