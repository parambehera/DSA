class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int i=0;
        int pow =1;
        while(i<=m){
            if(Math.pow(i,n)==m){
                return i;
            }
            i++;
        }
        return -1;
    }
}