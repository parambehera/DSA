import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start time

        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;

        list.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < n; i++) {
            int[] prev = list.get(list.size() - 1);
            int[] curr = intervals[i];

            int pst = prev[0];
            int pend = prev[1];
            int cst = curr[0];
            int cend = curr[1];

            if (pend >= cst) {
                prev[1] = Math.max(pend, cend);
            } else {
                list.add(new int[]{cst, cend});
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
