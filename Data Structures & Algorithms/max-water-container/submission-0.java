class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            int wid = r - l;
            int len = Math.min(heights[l], heights[r]);
            int a = len * wid;
            max = Math.max(max, a);
            if (heights[l] < heights[r]) {
                l++;
            } else if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return max;  
    }
}
