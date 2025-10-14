class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        
        int a =0;
        int b = a+k;
        int n = nums.size();
        while(b+k-1<n){
            if(isSub(a,nums,k) && isSub(b,nums,k)){
                return true;
            }
        a++;
        b++;
        }
        return false;

    }
    public boolean isSub(int a,List <Integer>list,int k){
        int i=a;
        while(i<a+k-1){
           if(list.get(i)>=list.get(i+1)){
            return false;
           }
           i++;
        }
        return true;
    }
}