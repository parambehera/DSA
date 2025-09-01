import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int[] curr = intervals[i];
            int cst = curr[0];
            int cend = curr[1];

            // Case 1: newInterval comes before current interval (no overlap)
            if (newInterval[1] < cst) {
                list.add(newInterval);
                // Add remaining intervals as-is
                overlap(list, i, intervals, n);
                return list.toArray(new int[list.size()][]);
            }
            // Case 2: newInterval comes after current interval (no overlap)
            else if (newInterval[0] > cend) {
                list.add(curr);
            }
            // Case 3: Overlap → merge
            else {
                newInterval[0] = Math.min(newInterval[0], cst);
                newInterval[1] = Math.max(newInterval[1], cend);
            }
        }

        // If newInterval comes after all intervals
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }

    private void overlap(ArrayList<int[]> list, int idx, int[][] intervals, int n) {
        for (int i = idx; i < n; i++) {
            list.add(intervals[i]);
        }
    }
}
