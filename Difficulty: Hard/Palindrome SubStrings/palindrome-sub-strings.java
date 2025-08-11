class Solution {
    public int countPS(String s) {
        // code here
        int n= s.length();
    //  boolean dp[][]= new boolean [n][n];
    int count =0;
     for(int i =0;i<n;i++){
         count += expandAroundcenter(i,i,s);
         count += expandAroundcenter(i,i+1,s);
     }
     return count;
    }
    public int expandAroundcenter(int left,int right,String s){
        int c=0;
        while(left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right))){
            if(right-left+1>=2) c++;
            left--;
            right++;
        }
        return c;
    }
}