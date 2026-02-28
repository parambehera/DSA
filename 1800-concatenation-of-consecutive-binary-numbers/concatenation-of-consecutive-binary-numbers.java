class Solution {
    public int concatenatedBinary(int n) {
      long MOD = 1000000007L;
      
      StringBuilder sb = new StringBuilder();
      int i =1;
      while(i<=n){
      String s = Integer.toBinaryString(i);
      sb.append(s);
      i++;
      }
      String fin = sb.toString();
      long res = 0;
      for(char ch :fin.toCharArray()){
        res = ((res*2)+(ch-'0'))%MOD;
      }
      return (int)res;
    }
}