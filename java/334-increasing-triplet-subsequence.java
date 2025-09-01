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
