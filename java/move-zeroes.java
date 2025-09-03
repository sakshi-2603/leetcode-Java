public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums1);
        System.out.print("Result: ");
        for (int n : nums1) {
            System.out.print(n + " ");
        }
        System.out.println(); // Expected: 1 3 12 0 0

        int[] nums2 = {0};
        sol.moveZeroes(nums2);
        System.out.print("Result: ");
        for (int n : nums2) {
            System.out.print(n + " ");
        }
        System.out.println(); // Expected: 0
    }
}
