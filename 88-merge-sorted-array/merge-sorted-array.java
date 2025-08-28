class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k=0;
       while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                i++;
            }else{
              int temp = nums1[i];
              nums1[i] = nums2[j];
              nums2[j] = temp;
              Arrays.sort(nums2);
              i++;
            }
       }
       while(j<n){
        nums1[i] = nums2[j];
        i++;
        j++;
       }

    }
}