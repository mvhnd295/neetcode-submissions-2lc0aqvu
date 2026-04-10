class Solution {
    public boolean alphaNum(char c) {
        return ('A' <= c && c <= 'Z') 
    || ('a' <= c && c <= 'z') 
    || ('0' <= c && c <= '9');
    }
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) l += 1;
            while (r > l && !alphaNum(s.charAt(r))) r -= 1;
            if (s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)) return false;
            l += 1;
            r -= 1;
        }
        return true;
    }
}
