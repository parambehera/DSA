class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList <Integer> list = new ArrayList <>();
       Deque <Integer> dq = new LinkedList<>();

       for(int i =0;i<nums.length;i++){
        if(!dq.isEmpty() && dq.peekFirst()<=i-k){
            dq.pollFirst();
        }
        while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
            dq.pollLast();
        }
         dq.offerLast(i);
         
         if(i >= k-1){
          list.add(nums[dq.peekFirst()]); // ✅ correct

         }
       }
        int res[]= new int [list.size()];
        for(int i =0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}