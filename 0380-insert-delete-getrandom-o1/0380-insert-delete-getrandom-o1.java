class RandomizedSet {
    HashMap<Integer,Integer> mp;
    ArrayList<Integer> nums;
    Random rn;
    public RandomizedSet() {
        this.mp=new HashMap<>();
        this.nums=new ArrayList<>();
        this.rn=new Random();
    }
    
    public boolean insert(int val) {
        if(!mp.containsKey(val)){
            mp.put(val,nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(mp.containsKey(val)){
            int idx=mp.remove(val);
            int lastVal=nums.remove(nums.size()-1);
            if(lastVal!=val){
                nums.set(idx,lastVal);
                mp.put(lastVal,idx);
            }
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return nums.get(rn.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */