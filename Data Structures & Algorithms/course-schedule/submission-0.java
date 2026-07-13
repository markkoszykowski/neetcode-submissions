class Solution {
    private static final class Result {
        boolean present = false;
        boolean result = false;
    }
    private static boolean canFinish(final int course, final Map<Integer, List<Integer>> requisites, final Map<Integer, Result> memo) {
        final Result result = memo.computeIfAbsent(course, k -> new Result());
        if (result.present) {
            return result.result;
        }
        result.present = true;
        result.result = false;
        final List<Integer> prerequisites = requisites.get(course);
        if (prerequisites != null) {
            for (final int prerequisite : prerequisites) {
                if (!canFinish(prerequisite, requisites, memo)) {
                    return result.result = false;
                }                
            }
        }
        return result.result = true;
    }

    public boolean canFinish(final int numCourses, final int[][] prerequisites) {
        final Map<Integer, List<Integer>> requisites = new HashMap<>();
        for (final int[] prerequisite : prerequisites) {
            requisites.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }
        final Map<Integer, Result> memo = new HashMap<>();
        for (int i = 0; i != numCourses; ++i) {
            if (!canFinish(i, requisites, memo)) {
                return false;
            }
        }
        return true;
    }
}
