class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) - 1);
            } else {
                return false;
            }
        }
        for (Integer count : counts.values()) {
            if (count != 0) {
                return false;
            } 
        }
        return true;
    }
}
/*
    count = {r: 2, a: 2, c: 1: e: 1}
*/