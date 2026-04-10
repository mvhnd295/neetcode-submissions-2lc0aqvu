class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int left = 0;
        
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        res[index++] = maxHeap.peek()[0];

        for (int right = k; right < nums.length; right++) {
            left++;
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < left) maxHeap.poll();
            maxHeap.offer(new int[]{nums[right], right});
            if (right == left + k - 1) res[index++] = maxHeap.peek()[0];
        }
        return res;
    }
}
