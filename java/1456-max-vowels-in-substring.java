import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int maxCount = 0;
        int currentCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currentCount++;
            }
            
            if (i >= k) {
                if (vowels.contains(s.charAt(i - k))) {
                    currentCount--;
                }
            }
            
            maxCount = Math.max(maxCount, currentCount);
        }
        
        return maxCount;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution(); // Use the correct class name
        
        System.out.println(solution.maxVowels("abciiidef", 3)); // Output: 3
        System.out.println(solution.maxVowels("aeiou", 2));     // Output: 2
        System.out.println(solution.maxVowels("leetcode", 3));  // Output: 2
    }
}
