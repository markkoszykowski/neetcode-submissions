class Solution {
    public int maxProfit(final int[] prices) {
        int max = 0;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        for (final int price : prices) {
            if (price < buy) {
                buy = price;
            } else {
                max = Math.max(max, price - buy);
                sell = Math.min(sell, price);
            }
        }
        return max;
    }
}
