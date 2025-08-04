import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
       Arrays.sort(arr);
        // code here
         int n = arr.length;
        int[] dp = new int[n];      // dp[i] = length of LIS ending at i
        int[] hash = new int[n];    // To track predecessors
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }
        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (isDivisible(arr[i],arr[prev]) && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            // Update the lastIndex of the LIS found so far
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        // Reconstruct LIS using hash[]
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);
        }


        Collections.reverse(lis);
        return lis;
    }
    boolean isDivisible(int x,int y){
        if(x%y==0 || y%x==0){
            return true;
        }else{
            return false;
        }
    }
}
