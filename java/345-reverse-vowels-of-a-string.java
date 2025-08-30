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

---

### Solution (Java)
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

  
