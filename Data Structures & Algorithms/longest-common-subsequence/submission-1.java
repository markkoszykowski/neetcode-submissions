class Solution {
    private static int get(final int[][] matrix, final int i, final int j) {
        final int m = matrix.length;
        final int n = 0 < matrix.length ? matrix[0].length : 0;
        return (0 <= i && i < m) && (0 <= j && j < n) ? matrix[i][j] : 0;
    }
    public int longestCommonSubsequence(final String text1, final String text2) {
        final int[][] lcs = new int[text1.length()][text2.length()];
        for (int i = 0; i != text1.length(); ++i) {
            for (int j = 0; j != text2.length(); ++j) {
                final int length = get(lcs, i - 1, j - 1) + (text1.charAt(i) == text2.charAt(j) ? 1 : 0);
                final int previous = Math.max(get(lcs, i - 1, j), get(lcs, i, j - 1));
                lcs[i][j] = Math.max(length, previous);
            }
        }
        return lcs[text1.length() - 1][text2.length() - 1];
    }
}
