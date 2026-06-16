class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length()) return false;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            count[index]--;
            if (count[index] < 0) return false;
        }
        return true;
    }
}
