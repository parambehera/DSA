class Solution {
    public int maximum69Number (int num) {
        String s = num+"";
        StringBuilder st = new StringBuilder("");
        int i =0;
       while(i<s.length()){
          if(s.charAt(i)=='6'){
            st.append("9");
            break;
          }else{
            st.append(s.charAt(i));
          }
          i++;
       }
       i++;
       while(i<s.length()){
        
        st.append(s.charAt(i));
        i++;
       }
       return Integer.parseInt(st.toString());
      
    }
}