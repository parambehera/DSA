class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int  n = arr.length-1;
        int left =0;
        int right =n;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==x) {
              while(mid<n&& arr[mid+1]==x)mid++;
              return mid;
            }
            if(arr[mid]>x) right = mid-1;
            if(arr[mid]<x) left = mid+1;
        }
        return right;
    }
}
