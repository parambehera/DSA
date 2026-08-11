class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0]+1;
        }
        int len =0;
        int currSum=0;
        for(int i=0;i<n-1;i++){
            int curr = nums[i];
            int nxt = nums[i+1];
            if(curr+1 ==nxt){
              currSum+=curr;
              len++;
              if(i==n-2)
              currSum +=nums[n-1];
            }else{
               currSum+=curr;
               len++;
               break;
            }
        }
        HashSet <Integer> set = new HashSet <>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        while(true){
            if(!set.contains(currSum)){
                return currSum;
            }
            currSum++;
        }
        
    }
}