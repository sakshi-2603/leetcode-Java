public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "the sky is blue";
        System.out.println(sol.reverseWords(s1)); // "blue is sky the"

        String s2 = "  hello world  ";
        System.out.println(sol.reverseWords(s2)); // "world hello"

        String s3 = "a good   example";
        System.out.println(sol.reverseWords(s3)); // "example good a"
    }
}

### Solution (Java)

class Solution {
    public String reverseWords(String s) {
        // Trim and split by spaces (ignoring multiple spaces)
        String[] words = s.trim().split("\\s+");
        
        // Reverse using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        
        return sb.toString();
    }
}
