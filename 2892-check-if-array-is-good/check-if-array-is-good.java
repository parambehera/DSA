class Solution {
    public boolean isGood(int[] nums) {
       int n = nums.length;
       int max= Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
          max = Math.max(max,nums[i]);
       }
       if(n!=max+1){
        return false;
       }
        
        HashSet <Integer> set =new  HashSet <>();
        int cnt =0;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
            if(nums[i]==max){
                cnt++;
            }
        }
        if(cnt!=2){
            return false;
        }
        int i=1;
        while(i<=max){
            if(!set.contains(i)){
                return false;
            }
            i++;
        }
        return true;

    }

}