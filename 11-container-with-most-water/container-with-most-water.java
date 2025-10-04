class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max =-1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int curr = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, curr);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;

    }
}