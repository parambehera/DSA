import java.util.Arrays;

class Solution {
    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (fun(stalls, mid, k) == 0) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int fun(int[] stalls, int diff, int k) {

        int last = stalls[0];
        k--;

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - last >= diff) {
                last = stalls[i];
                k--;
            }

            if (k == 0)
                return 0;
        }

        return -1;
    }
}