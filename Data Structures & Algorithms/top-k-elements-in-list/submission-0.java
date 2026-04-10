class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] buckets = new List[n+1];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : freq.keySet()) {
            if (buckets[freq.get(key)] == null) {
                buckets[freq.get(key)] = new ArrayList<>();
            }
            buckets[freq.get(key)].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for (int bucket = buckets.length - 1; bucket >= 0; bucket--) {
            if (buckets[bucket] != null) {
                for (int num : buckets[bucket]) {
                    result[index++] = num;
                    if (index == k) {
                        // Arrays.sort(result);
                        return result;
                    }
                }
            }
        }
        return new int[]{};
    }
}
