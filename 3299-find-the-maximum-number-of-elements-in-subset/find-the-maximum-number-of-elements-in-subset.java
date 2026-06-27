class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        for (long start : freq.keySet()) {

            // Handle 1 separately
            if (start == 1) {
                int cnt = freq.get(1L);
                if (cnt % 2 == 0) cnt--;
                ans = Math.max(ans, cnt);
                continue;
            }

            long cur = start;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                if (cur > (long) Math.sqrt(Long.MAX_VALUE))
                    break;

                cur = cur * cur;
            }

            if (freq.getOrDefault(cur, 0) >= 1)
                len++;
            else
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}