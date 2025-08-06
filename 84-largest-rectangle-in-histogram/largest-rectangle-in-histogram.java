class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        Stack<Integer> s = new Stack<>();
        
        // Calculate leftSmall
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                leftSmall[i] = -1;
            } else {
                leftSmall[i] = s.peek();
            }
            s.push(i);
        }
        
        // Reset the stack for the next calculation
        s = new Stack<>();
        
        // Calculate rightSmall
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                rightSmall[i] = n;
            } else {
                rightSmall[i] = s.peek();
            }
            s.push(i);
        }
        
        // Calculate areas and find the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
