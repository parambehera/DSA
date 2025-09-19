class Solution {
    public int minParentheses(String s) {
        // code here
      Stack <Character> st = new Stack <>();
      int n = s.length();
      for(int i=0;i<n;i++){
          char ch = s.charAt(i);
          if(!st.isEmpty() && st.peek()=='(' && ch==')'){
              st.pop();
          }
          else{
               st.push(ch);
          }
         
      }
      return st.size();
    }
}
