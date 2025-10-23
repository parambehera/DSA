class Solution {
    public boolean hasSameDigits(String s) {
      while(s.length()!=2){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length()-1;i++){
         int curNum = s.charAt(i);
         int nxtNum  = s.charAt(i+1);
         sb.append((curNum+nxtNum)%10);
        }
        s = sb.toString();
      }
      return s.charAt(0)==s.charAt(1);
    }
}