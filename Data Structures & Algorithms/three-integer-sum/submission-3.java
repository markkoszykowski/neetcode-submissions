class Solution {
    public List<List<Integer>> threeSum(final int[] nums) {
        Arrays.sort(nums);

        final Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i != nums.length; ++i) {
            final int numi = nums[i];
            int j = 0;
            int k = nums.length - 1;
            while (j < k) {
                final int numj = nums[j];
                final int numk = nums[k];
                final int sum = numi + numj + numk;
                if (sum < 0) {
                    ++j;
                } else if (0 < sum) {
                    --k;
                } else {
                    if (j != i && k != i) {
                        if (i < j) {
                            triplets.add(List.of(numi, numj, numk));
                        } else if (k < i) {
                            triplets.add(List.of(numj, numk, numi));
                        } else {
                            triplets.add(List.of(numj, numi, numk));
                        }
                    }
                    ++j;
                    --k;
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}
