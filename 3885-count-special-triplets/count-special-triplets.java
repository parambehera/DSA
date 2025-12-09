class Solution {
    public int specialTriplets(int[] nums) {
        HashMap <Integer,Integer> pre =new HashMap <>();
        HashMap <Integer,Integer> post =new HashMap <>();
          long MOD = 1000000007;
        int n = nums.length;
        long cnt =0;
        pre.put(nums[0],1);
        for(int i=2;i<n;i++){
          post.put(nums[i],post.getOrDefault(nums[i],0)+1);
        }
        for(int j=1;j<n-1;j++){
            int jv = nums[j];
            int rv = jv*2;
            if(pre.containsKey(rv) && post.containsKey(rv)){
               long left = pre.get(rv);
                long right = post.get(rv);
                cnt = (cnt + (left * right) % MOD) % MOD;
            }
            pre.put(jv,pre.getOrDefault(jv,0)+1);
            int nxt = nums[j+1];
            post.put(nxt,post.get(nxt)-1);
            if(post.get(nxt)==0){
                post.remove(nxt);
            }
        }
        return (int)cnt;
    }
}