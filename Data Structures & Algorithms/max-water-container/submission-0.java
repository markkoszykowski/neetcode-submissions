class Solution {
    public int maxArea(final int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            final int l = heights[left];
            final int r = heights[right];
            final int area = Math.min(l, r) * (right - left);
            max = Math.max(max, area);
            if (l < r) {
                ++left;
            } else {
                --right;
            }
        }
        return max;
    }
}
