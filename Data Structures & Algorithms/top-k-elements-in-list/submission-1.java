class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] buckets = new ArrayList[n + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (int key : freq.keySet()) {
            if (buckets[freq.get(key)] == null) buckets[freq.get(key)] = new ArrayList<>();
            buckets[freq.get(key)].add(key);
        }
        int index = 0;
        int[] result = new int[k];
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) return result;
                }
            }
        }
        return new int[]{};
    }
}
