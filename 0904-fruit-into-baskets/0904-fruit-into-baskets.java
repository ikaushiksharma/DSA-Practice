class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int res=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            mp.put(fruits[right],mp.getOrDefault(fruits[right],0)+1);
            while(mp.size()>2){
                mp.put(fruits[left],mp.get(fruits[left])-1);
                if(mp.get(fruits[left])==0) mp.remove(fruits[left]);
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}