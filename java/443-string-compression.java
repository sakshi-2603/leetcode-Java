public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] chars1 = {'a','a','b','b','c','c','c'};
        int len1 = sol.compress(chars1);
        System.out.print("Compressed: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(chars1[i]);
        }
        System.out.println(" | Length = " + len1); // a2b2c3 | Length = 6

        char[] chars2 = {'a'};
        int len2 = sol.compress(chars2);
        System.out.print("Compressed: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(chars2[i]);
        }
        System.out.println(" | Length = " + len2); // a | Length = 1

        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len3 = sol.compress(chars3);
        System.out.print("Compressed: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(chars3[i]);
        }
        System.out.println(" | Length = " + len3); // ab12 | Length = 4
    }
}
