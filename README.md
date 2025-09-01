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


LeetCode 151 - Reverse Words in a String
Problem
Given a string `s`, reverse the order of words.  
- Words are separated by spaces.  
- Reduce multiple spaces between words to a single space  
- Remove leading and trailing spaces.
  
Example
Input: s = "the sky is blue"
Output: "blue is sky the"
Input: s = " hello world "
Output: "world hello"
Input: s = "a good example"
Output: "example good a"

Solution (Java)
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

Explanation
Trim spaces to remove leading and trailing spaces.
Split with regex \\s+ → handles multiple spaces between words.
Reverse order of words with a loop.
Join them using a single space.

Complexity
Time: O(n) → single pass to split + reverse + build string
Space: O(n) → array of words (can be optimized to O(1) if done in-place with char array)

🔍 Example Run
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


LeetCode 238 - Product of Array Except Self
Problem
Given an integer array `nums`, return an array `answer` such that:
answer[i] = product of all nums[j] where j != i
Solve in O(n) time.
Do not use division.
  
Example
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Solution (Java)
import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: suffix products (multiply from right side)
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}

Explanation
Prefix Pass → store product of all elements to the left of i.
Example: for [1,2,3,4], prefix array = [1,1,2,6].
Suffix Pass → multiply from right side while updating result.
Multiply prefix[i] * suffix (right side product).
No division, only two passes.

Complexity
Time: O(n) (two linear passes)
Space: O(1) extra (ignoring output array)

Example Run
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,2,3,4};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums1))); 
        // [24, 12, 8, 6]

        int[] nums2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums2))); 
        // [0, 0, 9, 0, 0]
    }
}


443. String Compression
Problem Statement
Given an array of characters `chars`, compress it in-place using the following rules:
- For groups of consecutive repeating characters:
  - If length = 1 → write only the character.
  - If length > 1 → write character + count (count may span multiple digits).
- Return the new length of the array.

The algorithm must use only constant extra space.
Examples
Example 1
Input: ["a","a","b","b","c","c","c"]
Output: Length = 6, Array = ["a","2","b","2","c","3"]
Example 2
Input: ["a"]
Output: Length = 1, Array = ["a"]
Example 3 : 
Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Length = 4, Array = ["a","b","1","2"]

Constraints
- `1 <= chars.length <= 2000`
- `chars[i]` is a lowercase/uppercase letter, digit, or symbol.
Solution Approach
1. Use two pointers:
   - `i` → scans input
   - `index` → writes compressed output
2. Count each consecutive group of characters.
3. Write character + count (if >1).
4. Return the final `index` as new length.

⏱️ Time Complexity: O(n)  
📦 Space Complexity: O(1) (in-place)


LeetCode 334 - Increasing Triplet Subsequence

Problem
Given an integer array `nums`, return `true` if there exists a triple of indices `(i, j, k)` such that:
i < j < k AND nums[i] < nums[j] < nums[k]
Otherwise, return `false`.
Example
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: Triplet: (0,4,6)

Solution (Java)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                // update smallest so far
                first = n;
            } else if (n <= second) {
                // update second smallest
                second = n;
            } else {
                // found third > second > first
                return true;
            }
        }
        return false;
    }
}
Explanation
Keep track of two smallest numbers seen so far:
first → smallest element.
second → smallest element greater than first.
If we find a third number n > second, then an increasing triplet exists.
Otherwise, continue scanning.

Complexity
Time: O(n) → single pass.
Space: O(1) → only two variables.

Example Run
java
Copy code
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,2,3,4,5};
        System.out.println(sol.increasingTriplet(nums1)); 
        // true

        int[] nums2 = {5,4,3,2,1};
        System.out.println(sol.increasingTriplet(nums2)); 
        // false

        int[] nums3 = {2,1,5,0,4,6};
        System.out.println(sol.increasingTriplet(nums3)); 
        // true
    }
}
