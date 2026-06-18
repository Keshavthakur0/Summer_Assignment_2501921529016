class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = -1;
        for (int i = 1; i < n; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];
            }

            left[i] = p;
        }

        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < n && heights[p] >= heights[i]) {
                p = right[p];
            }

            right[i] = p;
        }

        int maximumArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maximumArea = Math.max(maximumArea, heights[i] * width);
        }

        return maximumArea;
    }
}