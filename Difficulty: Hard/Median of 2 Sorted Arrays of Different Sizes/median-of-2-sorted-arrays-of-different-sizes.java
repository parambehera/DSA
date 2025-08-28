class Solution {
    public double medianOf2(int nums1[], int nums2[]) {
        // Code Here
         int n = nums1.length;
        int m  = nums2.length;
        int arr[] = new int[n+m];
        int k =0;
        int i =0;
        int j =0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }else{
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i<n){
            arr[k] = nums1[i];
            k++;
            i++;       
             }
             while(j<m){
                arr[k] = nums2[j];
                k++;
                j++;
             }
             
    if(arr.length % 2 ==0){
        int idx1 = arr.length/2;
        int idx2 = idx1-1;
        return (arr[idx1]+arr[idx2])/2.0; 
    }
    int idx = arr.length/2;
    return arr[idx];
    }
}