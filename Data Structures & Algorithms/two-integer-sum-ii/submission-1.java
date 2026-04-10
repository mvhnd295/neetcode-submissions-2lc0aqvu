class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (seen.containsKey(complement)) {
                if (i + 1 < seen.get(complement) + 1) {
                    return new int[] {i + 1, seen.get(complement) + 1};
                } else {
                    return new int[] {seen.get(complement) + 1, i + 1};
                }
            }
            seen.put(numbers[i], i);
        }
        return new int[] {};
    }
}
