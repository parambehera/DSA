import java.util.HashMap;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int total = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            
            cnt += map.getOrDefault(total - k, 0);
            
            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return cnt;
    }
}
