class Solution {
    private static int change(final int[] coins, final int amount, final Map<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }
        final Integer result = memo.get(amount);
        if (result != null) {
            return result;
        }
        int min = -1;
        for (final int coin : coins) {
            if (coin <= amount) {
                final int change = change(coins, amount - coin, memo);
                if (change != -1) {
                    min = min == -1 ? (change + 1) : Math.min(min, change + 1);
                }
            }
        }
        memo.put(amount, min);
        return min;
    }

    public int coinChange(final int[] coins, final int amount) {
        return change(coins, amount, new HashMap<>());        
    }
}
