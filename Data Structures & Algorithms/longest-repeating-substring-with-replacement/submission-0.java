class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0;

        int l = 0;
        int maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            int index = s.charAt(r) - 'A';
            count[index] += 1;
            maxf = Math.max(maxf, count[index]);
            if ((r - l + 1) - maxf > k) {
                count[s.charAt(l) - 'A'] -= 1;
                l += 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
