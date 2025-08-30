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


LeetCode 1431 - Kids With the Greatest Number of Candies
Problem
There are `n` kids with candies.  
You are given an integer array `candies`, where `candies[i]` is the number of candies the `i-th` kid has, and an integer `extraCandies`.  

Return a boolean list `result` of length `n`, where `result[i]` is:
- `true` if, after giving the `i-th` kid all the `extraCandies`, they will have the **greatest number of candies** among all the kids.
- `false` otherwise.  
Example
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]

Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false]

Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]

Solution :
import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        // Step 1: Find maximum candies among all kids
        for (int c : candies) {
            max = Math.max(max, c);
        }

        // Step 2: Check each kid after adding extraCandies
        List<Boolean> result = new ArrayList<>();
        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }
        return result;
    }
}
Complexity
Time: O(n) (scan for max + build result)
Space: O(n) (result list)

Example Run
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] candies1 = {2,3,5,1,3};
        System.out.println(sol.kidsWithCandies(candies1, 3));
        // [true, true, true, false, true]

        int[] candies2 = {4,2,1,1,2};
        System.out.println(sol.kidsWithCandies(candies2, 1));
        // [true, false, false, false, false]

        int[] candies3 = {12,1,12};
        System.out.println(sol.kidsWithCandies(candies3, 10));
        // [true, false, true]
    }
}


LeetCode 605 - Can Place Flowers
Problem
You are given a long flowerbed (array) containing 0’s and 1’s, where:
- `0` → empty plot  
- `1` → already planted  
You want to plant `n` new flowers, but no two flowers can be adjacent**.  
Return `true` if you can plant all `n` flowers without violating the rule, otherwise `false`.
Example
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

Solution (Java)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        
        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft  = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == len - 1) || (flowerbed[i + 1] == 0);
                
                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1; // plant flower
                    n--;
                }
            }
        }
        
        return n == 0;
    }
}

Explanation
Loop through each plot.
If it’s empty (0) and both neighbors are empty (or edges), plant a flower (1).
Decrease n each time you plant.
If n reaches 0, return true.

Complexity
Time: O(n) (single scan through array)
Space: O(1) (in-place updates)

🔍 Example Run
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] f1 = {1,0,0,0,1};
        System.out.println(sol.canPlaceFlowers(f1, 1)); // true

        int[] f2 = {1,0,0,0,1};
        System.out.println(sol.canPlaceFlowers(f2, 2)); // false

        int[] f3 = {0,0,1,0,0};
        System.out.println(sol.canPlaceFlowers(f3, 2)); // true
    }
}


LeetCode 345 - Reverse Vowels of a String
Problem
Given a string `s`, reverse only all the vowels in the string and return it.  
The vowels are: `a, e, i, o, u` (both lowercase and uppercase).

Example
Input: s = "IceCreAm"
Output: "AceCreIm"
Input: s = "leetcode"
Output: "leotcede"

Solution (Java)
import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );
        
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(arr[left])) {
                left++;
            }
            while (left < right && !vowels.contains(arr[right])) {
                right--;
            }
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(arr);
    }
}
Explanation
Use two pointers (left and right) starting from both ends.
Skip non-vowel characters.
Swap vowels when both pointers point to vowels.
Continue until left >= right.

Complexity
Time: O(n) → single pass over the string
Space: O(n) → char array storage (in-place swap, but new string returned)

🔍 Example Run
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "IceCreAm";
        System.out.println(sol.reverseVowels(s1)); // "AceCreIm"

        String s2 = "leetcode";
        System.out.println(sol.reverseVowels(s2)); // "leotcede"

        String s3 = "aA";
        System.out.println(sol.reverseVowels(s3)); // "Aa"
    }
}
