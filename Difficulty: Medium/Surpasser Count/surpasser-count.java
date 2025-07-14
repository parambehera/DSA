import java.util.*;

class Solution {
    public List<Integer> findSurpasser(int[] arr) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = upperBound(sortedList, arr[i]);
            ans[i] = sortedList.size() - idx;
            sortedList.add(idx, arr[i]);  // insert at correct sorted position
        }

        for (int val : ans) {
            result.add(val);
        }

        return result;
    }

    // Find first index where list.get(index) > key
    
    private int upperBound(ArrayList<Integer> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
