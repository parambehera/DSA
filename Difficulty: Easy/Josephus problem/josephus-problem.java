class Solution {
    public int josephus(int n, int k) {
        // code here
        return fw(n,k)+1;
    }
   public int fw(int n,int k){
        if(n==1){
            return 0;
        }
        return (fw(n-1,k)+k)%n;
    }
}