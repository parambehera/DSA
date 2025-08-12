class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        HashSet <Integer> set = new HashSet <>();
        ArrayList <Integer> list = new ArrayList <>();
        int n  =arr.length;
        for(int i =0;i<n;i++){
          if(set.contains(arr[i])){
              list.add(arr[i]);
          }   
          set.add(arr[i]);
        }
        return list;
    }
}