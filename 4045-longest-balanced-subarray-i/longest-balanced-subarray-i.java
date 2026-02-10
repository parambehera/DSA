class Solution {
    public int longestBalanced(int[] nums) {
        HashSet <Integer> set = new HashSet <>();
        int n = nums.length;
        int ecnt =0;
        int ocnt=0;
        int len =0;
        for(int i=0;i<n;i++){
            ecnt=0;
            ocnt=0;
            set.clear();
            for(int j=i;j<n;j++){
              int num = nums[j];
              if(num%2==0 && !set.contains(num)){
                ecnt++;
              }else if (num%2!=0 &&!set.contains(num)){
                ocnt++;
              }
              if(ecnt==ocnt){
                len =Math.max(len,j-i+1);
              }
              set.add(num);
            }
        }
        return len;
    }
}