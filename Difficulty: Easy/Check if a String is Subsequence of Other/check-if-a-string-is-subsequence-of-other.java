class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int i=0;
        int j =0;
        while(i<s1.length() && j<s2.length()){
          char fc = s1.charAt(i);
          char sc = s2.charAt(j);
          if(fc==sc){
              i++;
              j++;
          }
          else{
              j++;
          }
        }
        if(i<s1.length()) return false;
        return true;
    }
};