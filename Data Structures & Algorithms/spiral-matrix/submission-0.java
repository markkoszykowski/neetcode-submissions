class Solution {
    public List<Integer> spiralOrder(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        int state = 0;
        
        int minx = 0;
        int maxx = m - 1;
        int miny = 0;
        int maxy = n - 1;
        
        int x = 0;
        int y = 0;

        final List<Integer> spiral = new ArrayList<>(m * n);
        for (int i = 0; i != (m * n); ++i) {
            spiral.add(matrix[x][y]);
            switch (state) {
                case 0 -> {
                    if (y == maxy) {
                        state = 1;
                        ++minx;
                        ++x;
                    } else {
                        ++y;                        
                    }
                }
                case 1 -> {
                    if (x == maxx) {
                        state = 2;
                        --maxy;
                        --y;
                    } else {
                        ++x;
                    }
                }
                case 2 -> {
                    if (y == miny) {
                        state = 3;
                        --maxx;
                        --x;
                    } else {
                        --y;
                    }
                }
                case 3 -> {
                    if (x == minx) {
                        state = 0;
                        ++miny;
                        ++y;
                    } else {
                        --x;
                    }
                }
            }
        }
        return spiral;
    }
}
