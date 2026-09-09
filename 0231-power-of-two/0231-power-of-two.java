class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
          // A power of 2 has exactly one 1 bit.
// For n - 1, that 1 becomes 0 and all bits after it become 1.
        return ((n & (n - 1)) == 0);
    }
}