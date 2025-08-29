class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If they don’t share common base, return ""
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // GCD of lengths
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
