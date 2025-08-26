class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double maxDiagonal = Double.MIN_VALUE;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = dimensions[i][0];
            int height = dimensions[i][1];
            double diagonal = Math.sqrt(width * width + height * height);

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = width * height;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, width * height);
            }
        }

        return maxArea;
    }
}
