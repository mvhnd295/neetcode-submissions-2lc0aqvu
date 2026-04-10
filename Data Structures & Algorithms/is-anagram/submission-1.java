class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            counts[index]++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            counts[index]--;
            if (counts[index] < 0) return false;
        }
        return true;
    }
}
