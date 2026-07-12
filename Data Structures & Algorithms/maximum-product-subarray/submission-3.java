class Solution {
    public int maxProduct(final int[] nums) {
        int max = nums[0];
        int currentMin = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i != nums.length; ++i) {
            final int num = nums[i];
            final int numMin = currentMin * num;
            final int numMax = currentMax * num;
            currentMin = Math.min(Math.min(numMin, numMax), num);
            currentMax = Math.max(Math.max(numMin, numMax), num);
            max = Math.max(max, Math.max(currentMax, currentMin));
        }
        return max;
    }
}
