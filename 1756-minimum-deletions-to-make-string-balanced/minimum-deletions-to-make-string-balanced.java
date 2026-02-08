// class Solution {
//     public int minimumDeletions(String s) {
//        Stack <Character> st = new Stack<>();
//        int cnt =0;
//        int n = s.length();
//        for(int i=0;i<n;i++){
//         char ch = s.charAt(i);
//         if(!st.isEmpty()&& st.peek()=='b'&&ch=='a'){
//                st.pop();
//                cnt++;
//             }
//         else{
//            st.push(ch);
//         }
//        }
//        return cnt;
//     }
// }

// class Solution {
//     public int minimumDeletions(String s){
//       int n = s.length();
//       int lb[]= new int [n];
//       int cntlb=0;
//       int ra[]= new int [n];
//       int cntra=0;
//       for(int i=0;i<n;i++){
//           lb[i]=cntlb;
//           if(s.charAt(i)=='b'){
//             cntlb++;
//           }
//       }
//       for(int i=n-1;i>=0;i--){
//         ra[i]=cntra;
//         if(s.charAt(i)=='a'){
//             cntra++;
//         }
//       }
//       int min =Integer.MAX_VALUE;
//       for(int i=0;i<n;i++){
//         min = Math.min(lb[i]+ra[i],min);
//       }
//       return min;
//     }
// }
class Solution {
    public int minimumDeletions(String s){
      int n = s.length();
      int cntlb=0;
      int cntra=0;
      for(int i=0;i<n;i++){
        if(s.charAt(i)=='a'){
            cntra++;
        }
      }
       int min =Integer.MAX_VALUE;
      for(int i=0;i<n;i++){
          if(s.charAt(i)=='a'){
            cntra--;
          }
           min = Math.min(cntlb+cntra,min);
          if(s.charAt(i)=='b'){
            cntlb++;
          }
      }
      return min;
    }
}