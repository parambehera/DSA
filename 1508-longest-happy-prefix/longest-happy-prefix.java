class Solution {
    public String longestPrefix(String s) {
         int n = s.length();
        int lps []= new int[n];
        int pre = 0;
        int suf = 1;
        while(suf<n){
            if(s.charAt(pre)==s.charAt(suf)){
              lps[suf] = pre+1;
              pre++;
              suf++;
            }else{
                if(pre==0){
                    lps[suf] =0;
                    suf++;
                }else{
                    pre = lps[pre-1];
                }
            }
        }
        int len = lps[n-1];
     return s.substring(0,len);
      
    }
}