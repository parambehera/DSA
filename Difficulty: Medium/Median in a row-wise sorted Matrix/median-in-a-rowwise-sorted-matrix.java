class Solution {
    public int median(int[][] mat) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: find min and max
        for(int i = 0; i < n; i++){
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][m - 1]);
        }

        int desire = (n * m + 1) / 2;

        // Step 2: binary search on value
        while(min < max){
            int mid = min + (max - min) / 2;
            int count = 0;

            for(int i = 0; i < n; i++){
                count += upperBound(mat[i], mid);
            }

            if(count < desire){
                min = mid + 1;   // ✅ FIX
            } else {
                max = mid;       // ✅ FIX
            }
        }

        return min; // or max (both same here)
    }

    public int upperBound(int mat[], int num){
        int n = mat.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mat[mid] <= num){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}