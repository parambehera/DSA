
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int left =0;
        int right =0;
        int sum =0;
        ArrayList <Integer> list = new ArrayList <>();
          
        while(right<arr.length){
             sum+=arr[right];
            while(sum>target){
                sum -=arr[left]; 
                left++;
            }
            if(sum==target){
                list.add(left+1);
                list.add(right+1);
                break;
            }
                right++;
            
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }
}
