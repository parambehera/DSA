import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        
        // Fixed typo: changed 'entreySet()' to 'entrySet()'
        int n = nums.length;
        ArrayList <Integer> arr[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = new ArrayList <>();
        }
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            arr[val].add(key);
        }
        int ans []= new int [k];
        int j =0;
        for(int i=n;i>=0 && j<k;i--){
            ArrayList <Integer> list = arr[i];
            for(int num :list){
                 if(j<k){
                    ans[j++] = num;
                 }else{
                    break;
                 }
            }
        }
        return ans;
    }
}
