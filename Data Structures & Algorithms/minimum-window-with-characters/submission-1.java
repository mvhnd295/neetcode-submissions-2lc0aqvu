class Solution {
    public String minWindow(String s, String t) {
        int[] mapT = new int[256];
        int[] mapS = new int[256];
        for (char c : t.toCharArray()) mapT[c]++;
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for (int r = 0; r < s.length(); r++) {
            mapS[s.charAt(r)]++;
            while (contains(mapS, mapT)) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                mapS[s.charAt(l)]--;
                l++;
            }
        }
        return minLen < Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
    }

    public Boolean contains(int[] mapS, int[] mapT) {
        for (int i = 0; i < 256; i++) if (mapT[i] > mapS[i]) return false;
        return true;
    }
}
