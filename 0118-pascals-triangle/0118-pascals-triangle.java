class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas=new ArrayList<List<Integer>>();
        int col=1;
        for(int i=0;i<numRows;i++){
            List<Integer> list1 = new ArrayList<Integer>();
            for(int j=0;j<col;j++){
                if(j==0 || j==col-1){
                    list1.add(1);
                }else{
                    list1.add(pas.get(i-1).get(j-1)+pas.get(i-1).get(j));
                }
            }
            col++;
            pas.add(list1);
        }
        return pas;
    }
}