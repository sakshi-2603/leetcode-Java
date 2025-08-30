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
Solution : Java 
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
