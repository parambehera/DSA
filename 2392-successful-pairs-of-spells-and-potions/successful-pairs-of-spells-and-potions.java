import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long minPotion = (long) Math.ceil((double) success / spells[i]);

            // Custom binary search to find first potion >= minPotion
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] < minPotion)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            res[i] = m - left;
        }
        return res;
    }
}
