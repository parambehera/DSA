class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixXor = 0;
        long cnt = 0;
        
        map.put(0, 1); 
        for (int num : arr) {
            prefixXor ^= num;

            cnt += map.getOrDefault(prefixXor ^ k, 0);

            map.put(prefixXor,
                    map.getOrDefault(prefixXor, 0) + 1);
        }

        return cnt;
    }
}
