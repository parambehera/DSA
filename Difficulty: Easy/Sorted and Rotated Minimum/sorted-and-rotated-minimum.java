// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int l =0;
        int h =arr.length-1;
        int min = Integer.MAX_VALUE;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[l]<=arr[mid]){
                min = Math.min(arr[l],min);
                l= mid+1;
            }else{
                min =Math.min(arr[mid],min);
                h = mid-1;
            }
        }
        return min;
        
    }
}
