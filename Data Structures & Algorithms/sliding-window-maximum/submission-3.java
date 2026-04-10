class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int left = 0;

        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        // maxHeap = [[1, 0], [2, 1], [1, 2]]
        res[index++] = maxHeap.peek()[0];
        // res = [2]

        for (int right = k; right < nums.length; right++) {
            //              R
            // [1, 2, 1, 0, 4, 2, 6]
            //     L
            left++; // left = 2
            while(!maxHeap.isEmpty() && maxHeap.peek()[1] < left) {
                maxHeap.poll();
            }
            maxHeap.offer(new int[]{nums[right], right});
            // maxHeap = [[2, 1], [1, 2], [0, 3], [4, 4]]
            //              R
            // [1, 2, 1, 0, 4, 2, 6]
            //        L 
            // maxHeap = [[1, 2], [0, 3], [4, 4]]

            // right = 4 = 1 + 4 - 1
            if (right == left + k - 1) {
                res[index++] = maxHeap.peek()[0];
                // res = [2, 2, 4]
            }
        }
        return res;
    }
}
