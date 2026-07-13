class Solution {
    private static boolean isAlphaNum(final char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c & c <= '9');
    }

    public boolean isPalindrome(final String s) {
        int start = 0;
        int stop = s.length() - 1;
        while (start < stop) {
            final char c1 = s.charAt(start);
            final char c2 = s.charAt(stop);
            final boolean alphanum1 = Character.isAlphabetic(c1) || Character.isDigit(c1);
            final boolean alphanum2 = Character.isAlphabetic(c2) || Character.isDigit(c2);
            if (alphanum1 == alphanum2) {
                if (alphanum1 && alphanum2 && Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                ++start;
                --stop;
            } else {
                start = start + (alphanum1 ? 0 : 1);
                stop = stop - (alphanum2 ? 0 : 1);
            }
        }
        return true;
    }
}
