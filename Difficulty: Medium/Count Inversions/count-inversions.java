class Solution {
    static int inversionCount(int arr[]) {
        return sort(0, arr.length - 1, arr);
    }

    public static int sort(int start, int end, int arr[]) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = sort(start, mid, arr);
        int right = sort(mid + 1, end, arr);
        int mergeCount = merge(start, mid, end, arr);
        return left + right + mergeCount;
    }

    public static int merge(int start, int mid, int end, int arr[]) {
        int res[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        int inversion = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
                inversion += (mid - i + 1); // all remaining left elements > arr[j]
            }
        }

        // Copy leftovers
        while (i <= mid) {
            res[k++] = arr[i++];
        }
        while (j <= end) {
            res[k++] = arr[j++];
        }

        // Copy back into original array
        for (int r = start, l = 0; r <= end; r++, l++) {
            arr[r] = res[l];
        }

        return inversion;
    }
}
