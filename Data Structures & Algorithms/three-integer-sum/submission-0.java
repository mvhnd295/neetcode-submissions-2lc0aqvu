class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                int currSum = nums[j] + nums[k];
                if (currSum < target) {
                    j++;
                } else if (currSum > target) {
                    k--;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
            i++;
        }
        return result;
    }
}
