class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        char[] sorted = s.toCharArray();

        // Step 1: Sort in descending order
        java.util.Arrays.sort(sorted);
        reverse(sorted);  // because Arrays.sort gives ascending order

        // Step 2: Find first mismatch index
        int i = -1;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] != sorted[k]) {
                i = k;
                break;
            }
        }

        // If no mismatch, already max
        if (i == -1) return s;

        // Step 3: Find rightmost occurrence of sorted[i] in original string
        int j = -1;
        for (int k = arr.length - 1; k > i; k--) {
            if (arr[k] == sorted[i]) {
                j = k;
                break;
            }
        }

        // Step 4: Swap characters at i and j
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }

    // Helper to reverse array
    private void reverse(char[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
