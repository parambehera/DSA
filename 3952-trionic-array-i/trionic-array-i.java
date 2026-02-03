class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p=0;
        for(p=0;p<n-1;){
            if(nums[p]<nums[p+1])p++;
            else break;
        }
        if(p>=n-2 || p==0)return false;
        int q=0;
        for(q=p;q<n-1;){
            if(nums[q]>nums[q+1])q++;
            else break;
        }
        if(q>=n-1 || q==0)return false;
        int l=0;
        for(l = q;l<n-1;){
            if(nums[l]<nums[l+1])l++;
            else break;
        }
        if(l==n-1)return true;
        return false;
    }
}