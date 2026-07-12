class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final int[] position = new int[128];
        Arrays.fill(position, -1);

        int longest = 0;
        int current = -1;
        for (int i = 0; i != s.length(); ++i) {
            final int previous = position[s.charAt(i)];
            current = Math.max(current, previous);
            longest = Math.max(longest, i - current);
            position[s.charAt(i)] = i;
        }
        return longest;
    }
}
