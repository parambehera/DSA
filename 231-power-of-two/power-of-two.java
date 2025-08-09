class Solution {
    public boolean isPowerOfTwo(int n) {
       int left =0;
       int right =(int) Math.ceil(Math.sqrt(n));
       while(left<=right){
        int mid = (left+right)/2;
        if(Math.pow(2,mid)==n) return true;
        if(Math.pow(2,mid)>n) right = mid-1;
        else left= mid+1;
       }
       return false;
    }
}