class Solution {
    public boolean canJump(final int[] nums) {
        final int start = -1;
        final int end = nums.length - 1;
        int position = 0;
        int farthest = 0;
        while (start < position && farthest < end) {
            final int jump = position + nums[position];
            if (farthest < jump) {
                position = jump;
                farthest = jump;
            } else {
                --position;
            }
        }
        return end <= farthest;
    }
}
