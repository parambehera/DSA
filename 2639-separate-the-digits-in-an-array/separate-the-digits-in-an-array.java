class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList <Integer> list = new ArrayList <>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int num = nums[i];
            int p = (num+"").length()-1;
            while(p>=0){
               int d =(int) Math.pow(10,p);
               int nnum = num/d;
               int r = nnum%10;
               list.add(r);
               p--;
            }
        }
        int res[]= new int [list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}