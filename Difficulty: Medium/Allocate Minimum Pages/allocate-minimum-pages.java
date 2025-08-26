class Solution {
    public int findPages(int[] arr, int k) {
        if (arr.length < k) return -1;

        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int st = isPossible(arr, mid);

            if (st > k) { 
                // too many students needed → increase pages
                min = mid + 1;
            } else {
                // feasible → try smaller
                max = mid - 1;
            }
        }
        return min;
    }

    public int isPossible(int arr[], int maxPages) {
        int st = 1;
        int pages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxPages) {
                return Integer.MAX_VALUE; // not possible
            }
            if (pages + arr[i] <= maxPages) {
                pages += arr[i];
            } else {
                st++;
                pages = arr[i];
            }
        }
        return st;
    }
}
