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


📝 LeetCode 1071 - Greatest Common Divisor of Strings
Problem
For two strings `s` and `t`, we say "`t` divides `s`" if and only if `s = t + t + ... + t` (t concatenated one or more times).  
Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

Example
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Input: str1 = "LEET", str2 = "CODE"
Output: ""
arduino
Copy code

Solution (Java)
java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If concatenation order mismatch, no common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
Complexity
Time: O(n + m) (concat check + gcd calculation)

Space: O(1)

Example Run
java
Copy code
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.gcdOfStrings("ABCABC", "ABC"));   // "ABC"
        System.out.println(sol.gcdOfStrings("ABABAB", "ABAB")); // "AB"
        System.out.println(sol.gcdOfStrings("LEET", "CODE"));   // ""
    }
}
