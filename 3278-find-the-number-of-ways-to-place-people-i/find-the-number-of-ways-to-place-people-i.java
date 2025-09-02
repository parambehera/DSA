import java.util.*;

class Solution {
    public int numberOfPairs(int[][] P) {
        // Sorting using custom comparator
        Arrays.sort(P, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]); // descending on first element
        });

        int n = P.length;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            int y = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (P[j][1] >= P[i][1] && y > P[j][1]) {
                    ans++;
                    y = P[j][1];
                }
            }
        }
        return ans;
    }
}
