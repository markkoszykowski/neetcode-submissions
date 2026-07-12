class Solution {
    private static final class Consecutive {
        int start;
        int stop;

        public Consecutive() {
        }

        public Consecutive(final int start, final int stop) {
            this.start = start;
            this.stop = stop;
        }
    }

    private static void expand(
        final Map<Integer, Consecutive> sequences,
        final int current, final int start, final int stop
    ) {
        final Consecutive consecutive = sequences.computeIfAbsent(current, k -> new Consecutive(start, stop));
        consecutive.start = Math.min(consecutive.start, start);
        consecutive.stop = Math.max(consecutive.stop, stop);
        if (current != consecutive.start && current != consecutive.stop) {
            expand(sequences, consecutive.start, consecutive.start, consecutive.stop);
            expand(sequences, consecutive.stop, consecutive.start, consecutive.stop);
        }
    }

    public int longestConsecutive(final int[] nums) {
        final Set<Integer> unique = new HashSet<>();
        for (final int num : nums) {
            unique.add(num);
        }

        final Map<Integer, Consecutive> sequences = new HashMap<>();
        for (final int num : nums) {
            final int start = unique.contains(num - 1) ? (num - 1) : num;
            final int stop = unique.contains(num + 1) ? (num + 1) : num;
            expand(sequences, num, start, stop);
        }

        int longest = 0;
        for (final Consecutive value : sequences.values()) {
            longest = Math.max(longest, value.stop - value.start + 1);
        }
        return longest;
    }
}
