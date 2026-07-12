class Solution {
    private static int get(final int[][] matrix, final int i, final int j) {
        final int m = matrix.length;
        final int n = 0 < matrix.length ? matrix[0].length : 0;
        return (0 <= i && i < m) && (0 <= j && j < n) ? matrix[i][j] : 0;
    }
    public int longestCommonSubsequence(final String text1, final String text2) {
        final int m = text1 == null ? 0 : text1.length();
        final int n = text2 == null ? 0 : text2.length();
        final int[][] lcs = new int[m][n];
        for (int i = 0; i != m; ++i) {
            for (int j = 0; j != n; ++j) {
                final int length = get(lcs, i - 1, j - 1) + (text1.charAt(i) == text2.charAt(j) ? 1 : 0);
                final int previous = Math.max(get(lcs, i - 1, j), get(lcs, i, j - 1));
                lcs[i][j] = Math.max(length, previous);
            }
        }
        return get(lcs, m - 1, n - 1);
    }
}
