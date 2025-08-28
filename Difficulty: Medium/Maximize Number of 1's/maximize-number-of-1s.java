class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int left =0;
        int right =0;
        HashMap <Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(right =0;right<arr.length;right++){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            
            while(map.containsKey(0) && map.get(0)>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
            
        }
        return ans;
    }
}