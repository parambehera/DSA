class Solution {
    public int minimumDeletions(String s) {
       Stack <Character> st = new Stack<>();
       int cnt =0;
       int n = s.length();
       for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        if(!st.isEmpty()&& st.peek()=='b'&&ch=='a'){
               st.pop();
               cnt++;
            }
        else{
           st.push(ch);
        }
       }
       return cnt;
    }
}