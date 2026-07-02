class Solution {
    ArrayList<Integer> find(int arr[], int x) {

        ArrayList<Integer> list = new ArrayList<>();

        int n = arr.length;

        // ---------- First Occurrence ----------
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int first = -1;

        if (low < n && arr[low] == x) {
            first = low;
        }

        // ---------- Last Occurrence ----------
        low = 0;
        high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int last = -1;

        if (low > 0 && arr[low - 1] == x) {
            last = low - 1;
        }

        list.add(first);
        list.add(last);

        return list;
    }
}