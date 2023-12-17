class Solution {
    public int numRabbits(int[] answers) {
        int res=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:answers){
            mp.put(i+1,mp.getOrDefault(i+1,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            int key=e.getKey();
            double val=e.getValue();
            int rabbits=(key*(int)(Math.ceil(val/key)));
            System.out.println(rabbits);
            res+=rabbits;
        }
        return res;
    }
}