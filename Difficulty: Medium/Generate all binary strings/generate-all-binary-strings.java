class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
     ArrayList <String> list = new ArrayList <>();
     int j =0;
     while(true){
         String s = Integer.toBinaryString(j);
         if(s.length()>n) break;
         if(s.length()<n){
             int zn = n-s.length();
             while(zn!=0){
                 s = 0+s;
                 zn--;
             }
         }
         j++;
         list.add(s);
     }
      Collections.sort(list);
      return list;
    }
}
