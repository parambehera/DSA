class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] have = new int[n];

        // Step 1: Count trailing zeros in each row
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {   // fixed j--
                if (grid[i][j] == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            have[i] = cnt;
        }

        int swaps = 0;

        // Step 2: Try to arrange rows
        for (int i = 0; i < n; i++) {
            int need = n - i - 1;

            int j = i;

            // Find row with enough trailing zeros
            while (j < n && have[j] < need) {
                j++;
            }

            // If no such row found
            if (j == n) return -1;

            // Bring row up using adjacent swaps
            while (j > i) {
                swap(have, j, j - 1);
                swaps++;
                j--;
            }
        }

        return swaps;
    }

    // ✅ Swap function
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}