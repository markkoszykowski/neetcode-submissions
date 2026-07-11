class Solution {
    private static boolean isPalindrome(final CharSequence cs, final int start, final int stop) {
        for (int i = start, j = stop - 1; i < j; ++i, --j) {
            if (cs.charAt(i) != cs.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static void palindromes(
        final CharSequence cs, final int start, final int stop, 
        final List<String> current, final List<List<String>> palindromes
    ) {
        if (start == stop) {
            palindromes.add(current);
            return;
        }
        for (int i = stop; i != start; --i) {
            if (isPalindrome(cs, start, i)) {
                final List<String> clone = new ArrayList<>(current);
                clone.add(cs.subSequence(start, i).toString());
                palindromes(cs, i, stop, clone, palindromes);
            }
        }
    }

    public List<List<String>> partition(final String s) {
        final List<List<String>> palindromes = new ArrayList<>();
        palindromes(s, 0, s.length(), Collections.emptyList(), palindromes);
        return palindromes;
    }
}
