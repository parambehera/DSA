class Solution {
    public int minTime(int[] arr, int k) {
        int lb = 0;
        for (int val : arr) {
            lb = Math.max(lb, val);
        }
        int hb = 0;
        for (int val : arr) {
            hb += val;
        }

        while (lb <= hb) {
            int mid = lb + (hb - lb) / 2;
            int lv = isPossible(arr, k, mid);
            if (lv <= k) { // can be done, try smaller max time
                hb = mid - 1;
            } else {       // need more workers, increase time
                lb = mid + 1;
            }
        }
        return lb;
    }

    public int isPossible(int arr[], int k, int maxTime) {
        int workers = 1;
        int time = 0;

        for (int val : arr) {
            if (val > maxTime) return Integer.MAX_VALUE; 
            if (time + val <= maxTime) {
                time += val;
            } else {
                workers++;
                time = val;
            }
        }
        return workers;
    }
}
