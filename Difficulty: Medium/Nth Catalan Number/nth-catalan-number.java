
class Solution {
    public static int findCatalan(int n) {
        // code here
        int dp[]= new int [n+1];
        Arrays.fill(dp,-1);
        return f(dp,n);
      
    }
  public static int f(int dp[],int n){
        if(n==0 || n==1) return 1;
        
        if(dp[n]!=-1) return dp[n];
        
         int sum =0;
         
        for(int i =0;i<n;i++){
            sum+= f(dp,i)*f(dp,n-i-1);
        }
        return dp[n]=sum;
    }
}
