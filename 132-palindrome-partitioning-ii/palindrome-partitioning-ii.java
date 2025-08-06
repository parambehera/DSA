// class Solution {
//     public int minCut(String s) {
//         int n = s.length();
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return f(0, dp, s) - 1; // subtract 1 to get minimum cuts
//     }

//     public int f(int i, int[] dp, String s) {
//         if (i == s.length()) return 0;
//         if (dp[i] != -1) return dp[i];

//         int cost = Integer.MAX_VALUE;
//         for (int j = i; j < s.length(); j++) {
//             if (isPalindrome(i, j, s)) {
//                 int c = 1 + f(j + 1, dp, s);
//                 cost = Math.min(cost, c);
//             }
//         }

//         return dp[i] = cost;
//     }

//     public boolean isPalindrome(int i, int j, String s) {
//         while (i < j) {
//             if (s.charAt(i) != s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[]= new int [n+1];
        for(int i =n-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPallindrom(i,j,s)){
                    int cost = 1+dp[j+1];
                    min = Math.min(cost,min);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
}
public boolean isPallindrom(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}