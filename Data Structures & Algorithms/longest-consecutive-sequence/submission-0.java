class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        if (nums.length == 0) return 0;
        for (int num : nums) {
            set.add(num);
        }
        // set = {2,20,4,10,3,5}, {0,3,2,5,4,6,1}
        for (int num : nums) {
            if (!set.contains(num -1)) {
                int curr = num;
                int streak = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                max = Math.max(max, streak);
            }
        }
        return max;
    }
}
