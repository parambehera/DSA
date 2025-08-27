import java.util.*;

class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int sum = arr[i] + arr[j];

                // binary search for largest index k such that arr[k] < sum
                int left = j + 1, right = n - 1, idx = j;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] < sum) {
                        idx = mid;   // valid candidate
                        left = mid + 1; 
                    } else {
                        right = mid - 1;
                    }
                }

                cnt += (idx - j);  // number of valid ks
            }
        }
        return cnt;
    }
}
