class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        int i = 0, j = 0;
        boolean takeFirst = true;
        while (i < word1.length() && j < word2.length()) {
            if (takeFirst) sb.append(word1.charAt(i++));
            else           sb.append(word2.charAt(j++));
            takeFirst = !takeFirst;
        }
        if (i < word1.length()) sb.append(word1.substring(i));
        if (j < word2.length()) sb.append(word2.substring(j));
        return sb.toString();
    }
}
