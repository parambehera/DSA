class Solution {

    public static long countKdivPairs(int arr[], int n, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int rem = arr[i] % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        long cnt = 0;

        HashSet<Integer> visited = new HashSet<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(visited.contains(key)) {
                continue;
            }
            int diff = (k - key) % k;
            // remainder 0 OR k/2 case
            if(key == diff) {
                cnt += (long)val * (val - 1) / 2;
            }
            else {
                int valDiff = map.getOrDefault(diff, 0);
                cnt += (long)val * valDiff;
            }
            visited.add(key);
            visited.add(diff);
        }

        return cnt;
    }
}