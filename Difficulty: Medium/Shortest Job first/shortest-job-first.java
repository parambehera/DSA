// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n = bt.length;
        int sum=0;
        int tsum=0;
        for(int i =1;i<bt.length;i++){
            sum+=bt[i-1];
             tsum +=sum;
         }
         return tsum/n;
         
    }
}
