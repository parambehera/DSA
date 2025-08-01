class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList <>();
        List <Integer> n = new ArrayList <>();
        n.add(1);
        list.add(n);
        if(numRows==1){
            return list;
        }
        for(int i =1;i<numRows;i++){
           List <Integer> ns = new ArrayList <>();
           ns.add(1);
           for(int j =0;j<i-1;j++){
             ns.add(list.get(list.size()-1).get(j)+list.get(list.size()-1).get(j+1));
           }
           ns.add(1);
          list.add(ns);
        }
        return list;
    }
}