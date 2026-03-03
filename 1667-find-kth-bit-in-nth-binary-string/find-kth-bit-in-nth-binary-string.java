class Solution {
    public char findKthBit(int n, int k) {
      StringBuilder sb =new StringBuilder("0");
      String str = "0";
      int i=2;
      while(i<=n){
         StringBuilder  prev = new StringBuilder(sb);
         sb.append("1");
         String invert = invert(prev.toString());
         sb.append(invert);
         i++;
      }
      return sb.charAt(k-1);
    }
    public String invert(String s ){
      StringBuilder inv = new StringBuilder();
      for(char ch :s.toCharArray()){
        if(ch=='0'){
            inv.append("1");
        }else{
            inv.append("0");
        }
      }
      inv.reverse();
      return inv.toString();
    }
}