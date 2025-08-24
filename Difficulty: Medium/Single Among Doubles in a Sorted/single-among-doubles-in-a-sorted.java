class Solution {
    int single(int[] arr) {
        // code here
        //this qustion can be done in n also
        int n =arr.length;
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        int l=1;
        int h =n-2;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            if((mid%2==0) && arr[mid+1]==arr[mid]){
                l = mid+1;
            }
            else if((mid%2!=0) && arr[mid-1]==arr[mid]){
                l = mid+1;
            }
            else{
                h  = mid-1;
            }
        }
        return -1;
    }
}