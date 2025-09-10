import java.util.HashMap;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int operations = 0;
        
        for (int num : nums) {
            int complement = k - num;
            if (map.getOrDefault(complement, 0) > 0) {
                operations++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        return operations;
    }
    
    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.println(solution.maxOperations(nums1, k1));  // Output: 2
        
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println(solution.maxOperations(nums2, k2));  // Output: 1
    }
}
