class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int left =0;
        int right = n-1;
        int ans = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==k){
                ans = mid;
                right = mid-1;
            }
            else if(arr[mid]>k){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
        
    }
}