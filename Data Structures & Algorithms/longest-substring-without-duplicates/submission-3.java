class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dupCheck = new HashSet<>();
        int longest = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            while (!dupCheck.add(s.charAt(r))) {
                dupCheck.remove(s.charAt(l));
                l++;      
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }
        return longest;
    }
}
