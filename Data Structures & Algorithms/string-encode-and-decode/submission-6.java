class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int left = 0;
        while (index < str.length()) {
            if (str.charAt(index) == '#') {
                int len = Integer.parseInt(str.substring(left, index));
                result.add(str.substring(index + 1, index + len + 1));
                index += len + 1;
                left = index;
            } else {
                index++;
            }
        }
        return result;
    }
}

