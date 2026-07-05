class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0, m = s.length();
        for (char c : t.toCharArray()) {
            if (i < m && s.charAt(i) == c) i++;
            i = Math.max(i, j + 1);
            if (j < m && s.charAt(j) == c) j++;
            if (i == m || j == m) return true;
        }
        return false;
    }
}