class Solution {
    private static boolean catchesUp(
        final int target, 
        final int ahead, final int behind,
        final int[] position, final int[] speed
    ) {
        final double aheadTime = ((double)(target - position[ahead])) / speed[ahead];
        final double behindTime = ((double)(target - position[behind])) / speed[behind];
        return behindTime <= aheadTime;
    }

    public int carFleet(final int target, final int[] position, final int[] speed) {
        final Integer[] cars = new Integer[position.length];
        for (int i = 0; i != cars.length; ++i) {
            cars[i] = i;
        }
        Arrays.sort(cars, (left, right) -> { return position[right] - position[left]; });
        
        int fleets = 1;
        int head = 0;
        for (int i = 1; i != cars.length; ++i) {
            if (!catchesUp(target, cars[head], cars[i], position, speed)) {
                fleets += 1;
                head = i;
            }
        }
        
        return fleets;
    }
}
