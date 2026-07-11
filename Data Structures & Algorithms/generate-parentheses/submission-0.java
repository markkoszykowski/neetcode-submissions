class Solution {
    private static void generate(
        final String current, final int n, 
        final int open, final int close, 
        final List<String> parenthesis
    ) {
        if (current.length() == n * 2) {
            parenthesis.add(current);
            return;
        }
        if (close < open) {
            generate(current + ")", n, open, close + 1, parenthesis);
        }
        if (open < n) {
            generate(current + "(", n, open + 1, close, parenthesis);
        }
    }

    public List<String> generateParenthesis(final int n) {
        final List<String> parenthesis = new ArrayList<>();
        generate("", n, 0, 0, parenthesis);
        return parenthesis;
    }
}
