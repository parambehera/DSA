import java.util.*;

class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int ans = arr[n - 1] - arr[0]; // initial diff
        
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        for (int i = 0; i < n - 1; i++) {
            int minVal = Math.min(smallest, arr[i + 1] - k);
            int maxVal = Math.max(largest, arr[i] + k);
            
            if (minVal < 0) continue; // skip negative height
            
            ans = Math.min(ans, maxVal - minVal);
        }
        
        return ans;
    }
}
