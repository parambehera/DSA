class Solution {
    List<List <Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int res[]= new int [nums.length];
        Arrays.fill(res,Integer.MAX_VALUE);
        allpermute(res,0,nums);
        return finalList;
    }
    public void allpermute(int res[],int idx,int nums[]){
        if(idx==nums.length){
            List <Integer> list = new ArrayList <>();
            for(int i=0;i<res.length;i++){
                list.add(res[i]);
            }
            finalList.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(res[i]==Integer.MAX_VALUE){
               res[i] = nums[idx];
                int nextIdex = idx+1;
            allpermute(res,nextIdex,nums);
            res[i] = Integer.MAX_VALUE;
            }
           
        }
    }
}