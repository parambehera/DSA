class Solution {

    public char[][] rotateTheBox(char[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        // apply gravity
        for (int i = 0; i < n; i++) {

            for (int j = m - 1; j >= 0; j--) {

                if (arr[i][j] == '.') {

                    int idx = j - 1;

                    // find nearest non-empty and non-obstacle
                    while (idx >= 0 && arr[i][idx] == '.') {
                        idx--;
                    }

                    // move stone
                    if (idx >= 0 && arr[i][idx] == '#') {

                        arr[i][j] = '#';
                        arr[i][idx] = '.';
                    }
                }

                // obstacle handling
               
            }
        }

        // rotate matrix
        char ans[][] = new char[m][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                ans[j][n - 1 - i] = arr[i][j];
            }
        }

        return ans;
    }
}