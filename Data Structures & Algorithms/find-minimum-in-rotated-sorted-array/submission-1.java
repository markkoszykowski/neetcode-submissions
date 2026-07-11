class Solution {
    private static boolean rotated(final int[] nums, final int i) {
        return 0 < i && nums[i - 1] > nums[i]; 
    }

    private static Integer partition(final int[] nums, final int low, final int high) {
        if (high < low) {
            return null;
        }
        final int mid = (low + high) >>> 1;
        if (rotated(nums, mid)) {
            return mid;
        }
        if (low != high) {
            final Integer left = partition(nums, low, mid - 1);
            if (left != null) {
                return left;
            }
            final Integer right = partition(nums, mid + 1, high);
            if (right != null) {
                return right;
            }
        }
        return null;
    } 

    public int findMin(final int[] nums) {
        final Integer min = partition(nums, 0, nums.length - 1);
        return nums[min == null ? 0 : min];
    }
}
