import java.util.*;

class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // build suffix min array
        int[] suff = new int[n];
        suff[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suff[i] = Math.min(arr[i], suff[i + 1]);
        }

        // binary search for farthest smaller
        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n - 1, res = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (suff[mid] < arr[i]) {
                    res = mid;
                    lo = mid + 1; // search farther
                } else {
                    hi = mid - 1;
                }
            }
            ans[i] = res;
        }

        // convert int[] → ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int x : ans) result.add(x);
        return result;
    }
}
