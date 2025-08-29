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


solution
  import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        List<Boolean> result = new ArrayList<>();
        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }
        return result;
    }
}
