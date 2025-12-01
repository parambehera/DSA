import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        return scan(nums);
    }

    private int scan(int[] a) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> m = new HashMap<>();
        int len = a.length;
        int i = 0;

        while (i < len) {
            int cur = a[i];
            if (m.containsKey(cur)) {
                int prev = m.get(cur);
                int d = i - prev;
                if (d < res) res = d;
            }
            int r = rev(cur);
            m.put(r, i);
            i++;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int rev(int x) {
        int y = 0;
        while (x > 0) {
            y = y * 10 + (x % 10);
            x /= 10;
        }
        return y;
    }
}
