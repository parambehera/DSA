class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low =0;
        int high = m/n;
    
        while(low<=high){
            int mid = low+(high-low)/2;
            int mr = (int)Math.pow(mid,n);
            if(mr==m){
                return mid;
            }
            else if(mr<m){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}