class Solution {
    public int majorityElement(int[] nums) {
     int ele = nums[0];
     int cnt =1;
     int n = nums.length;
     for(int i=1;i<n;i++){
        if(cnt==0){
            cnt=1;
            ele = nums[i];
        }
        else{
            if(nums[i]!=ele) cnt--;
            else cnt++;
        }
     }
     return ele;
    }
}