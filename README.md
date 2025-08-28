LeetCode 1768 - Merge Strings Alternately
Problem
You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`.  
If one string is longer, append the remaining letters at the end.
Approach
- Use two pointers to traverse both strings.
- Append characters alternately.
- Append any remaining part of the longer string.  

Time Complexity: O(n + m)  
Space Complexity: O(n + m)

Java Solution
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
Example Run
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.mergeAlternately("abc", "pqr"));   // apbqcr
        System.out.println(sol.mergeAlternately("ab", "pqrs"));   // apbqrs
        System.out.println(sol.mergeAlternately("abcd", "pq"));   // apbqcd
    }
}
