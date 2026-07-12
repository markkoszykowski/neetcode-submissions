class Solution {
    private static boolean isPalindrome(final CharSequence cs, final int start, final int stop) {
        for (int i = start, j = stop - 1; i < j; ++i, --j) {
            if (cs.charAt(i) != cs.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static int get(final int[] array, final int i) {
        return 0 <= i && i < array.length ? array[i] : 0;
    }

    public int countSubstrings(final String s) {
        final int[] memo = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            int palindromes = 0;
            for (int j = 0; j <= i; ++j) {
                if (isPalindrome(s, j, i + 1)) {
                    palindromes += 1;
                }
            }
            memo[i] = get(memo, i - 1) + palindromes;
        }
        return memo[memo.length - 1];
    }
}
