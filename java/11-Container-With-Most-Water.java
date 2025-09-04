class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);

            // Move the smaller line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
