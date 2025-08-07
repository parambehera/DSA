class Solution {
    Boolean[][] dp;

    int stringConversion(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        dp = new Boolean[n + 1][m + 1]; // Use wrapper Boolean to allow null checks
        return f(n, m, X, Y) ? 1 : 0;
    }

    boolean f(int i, int j, String x, String y) {
        // i: length of current prefix in x
        // j: length of current prefix in y

        if (j == 0) {
            // Y is empty. Check if remaining x[0..i-1] has any uppercase (invalid)
            for (int k = 0; k < i; k++) {
                if (Character.isUpperCase(x.charAt(k))) return false;
            }
            return true;
        }

        if (i == 0) return false; // X is empty, Y is not => not possible

        if (dp[i][j] != null) return dp[i][j];

        char a = x.charAt(i - 1);
        char b = y.charAt(j - 1);

        boolean ans;

        if (Character.toUpperCase(a) == b) {
            if (Character.isUpperCase(a)) {
                // Must match directly
                ans = (a == b) && f(i - 1, j - 1, x, y);
            } else {
                // Two choices: convert to uppercase and match, or delete
                ans = f(i - 1, j - 1, x, y) || f(i - 1, j, x, y);
            }
        } else {
            // Can't match, try deleting if lowercase
            if (Character.isLowerCase(a)) {
                ans = f(i - 1, j, x, y); // delete a
            } else {
                ans = false; // can't delete uppercase
            }
        }

        return dp[i][j] = ans;
    }
}
