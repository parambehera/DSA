class Solution {
    static boolean canAttend(int[][] meetings) {

        int n = meetings.length;

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, meetings[i][1]);
        }

        int diff[] = new int[max + 1];

        for (int i = 0; i < n; i++) {

            int st = meetings[i][0];
            int end = meetings[i][1];

            diff[st]++;

            // end is excluded
            if (end < diff.length)
                diff[end]--;
        }

        int curr = 0;

        for (int i = 0; i < diff.length; i++) {

            curr += diff[i];

            if (curr >= 2)
                return false;
        }

        return true;
    }
}