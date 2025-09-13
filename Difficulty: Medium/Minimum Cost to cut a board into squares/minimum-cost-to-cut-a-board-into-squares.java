import java.util.*;

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // Sort in descending order
        Arrays.sort(x);
        reverse(x);
        Arrays.sort(y);
        reverse(y);

        int i = 0, j = 0;
        int total = 0;
        int vs = 1; // vertical segments
        int hs = 1; // horizontal segments

        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                total += x[i] * vs;
                hs++;
                i++;
            } else {
                total += y[j] * hs;
                vs++;
                j++;
            }
        }

        // Remaining cuts
        while (i < x.length) {
            total += x[i] * vs;
            hs++;
            i++;
        }

        while (j < y.length) {
            total += y[j] * hs;
            vs++;
            j++;
        }

        return total;
    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
