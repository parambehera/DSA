class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp [][] = new int [n][m];
        for(int [] row :dp){
            Arrays.fill(row,-1);
        }
        return ascii(s1,s2,0,0,dp);
    }
    public int ascii(String s1,String s2,int i,int j,int dp[][]){

        int n = s1.length();
        int m = s2.length();
        
        if(i>=n && j>= m){
            return 0;
        }
       
        if(i>=n){
            return (int)s2.charAt(j)+ascii(s1,s2,i,j+1,dp);
        }
        if(j>=m){
        return  (int)s1.charAt(i)+ascii(s1,s2,i+1,j,dp);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       if(s1.charAt(i) ==s2.charAt(j)){
         return ascii(s1,s2,i+1,j+1,dp);
       }
       else{
        return dp[i][j]=Math.min((int)s2.charAt(j)+ascii(s1,s2,i,j+1,dp), (int)s1.charAt(i)+ascii(s1,s2,i+1,j,dp));
       }
    }
}