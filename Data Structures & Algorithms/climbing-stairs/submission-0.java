class Solution {
    public int climbStairs(final int n) {
        if (n == 1) {
            return 1;
        }
        int ways2 = 1;
        int ways1 = 2;
        for (int i = 2; i != n; ++i) {
            final int temp = ways1 + ways2;
            ways2 = ways1;
            ways1 = temp;
        }
        return ways1;
    }
}
