class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int even [] = new int[len/2];
        int odd []= new int [len/2];
        int j=0,k=0;
        for(int i=0;i<len;i++){
           int num = nums[i];
           if(num<0){
               even[j] = num;
               j++;
           }else{
            odd[k] =num;
            k++;
           }
        }
        
        int res []= new int [len];
        int i=0;
         j=0;
         k=0;
       while(i<len){
         res[i] = odd[j];
         i++;
         res[i] = even[k];
         i++;
         j++;
         k++;
       }
       return res;

    }
}