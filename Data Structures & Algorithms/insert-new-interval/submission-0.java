class Solution {
    private static boolean mergable(final int[] left, final int[] right) {
        final int leftStart = left[0];
        final int leftEnd = left[1];
        final int rightStart = right[0];
        final int rightEnd = right[1];
        return (leftStart <= rightStart && rightStart <= leftEnd) ||
               (rightStart <= leftStart && leftStart <= rightEnd);
    }

    private static int[] merge(final int[] left, final int[] right) {
        return new int[] {
            Math.min(left[0], right[0]), 
            Math.max(left[1], right[1])
        };
    }

    public int[][] insert(final int[][] intervals, final int[] newInterval) {
        final List<int[]> merged = new ArrayList<>();
        int[] todo = newInterval;
        for (final int[] interval : intervals) {
            int[] m = interval;
            if (todo != null) {
                if (mergable(m, todo)) {
                    m = merge(m, todo);
                    todo = null;
                } else if (todo[1] < m[0]) {
                    merged.add(todo);
                    todo = null;
                }
            }
            if (!merged.isEmpty() && mergable(m, merged.getLast())) {
                m = merge(m, merged.removeLast());
            }
            merged.add(m);
        }
        if (todo != null) {
            merged.add(todo);
            todo = null;
        }
        return merged.toArray(int[][]::new);
    }
}
