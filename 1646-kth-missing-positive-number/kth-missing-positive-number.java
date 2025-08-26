class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lb =0;
         int hb = arr.length-1;
         while(lb<=hb){
            int mid = lb+(hb-lb)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k){
                lb = mid+1;
            }else{
                hb = mid-1;
            }
         }
         return lb+k;
    }
}