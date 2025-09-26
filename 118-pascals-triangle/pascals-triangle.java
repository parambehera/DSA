class Solution {
    public List<List<Integer>> generate(int numRows) {
        List <List <Integer>> list = new ArrayList <>();
         for(int n =1;n<=numRows;n++){
            List<Integer> l = new ArrayList <>();
            int val = 1;
            for(int r=0;r<n;r++){
                l.add(val);
                val = val*(n-r-1)/(r+1);
            }
            list.add(l);
         }
         return list;
    }
}