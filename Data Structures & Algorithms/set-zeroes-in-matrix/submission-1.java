class Solution {
    public void setZeroes(final int[][] matrix) {
        final int m = matrix == null ? 0 : matrix.length;
        final int n = m == 0 ? 0 : matrix[0].length;

        boolean x0 = false;
        for (int y = 0; y != n; ++y) {
            x0 |= matrix[0][y] == 0;
        }
        boolean y0 = false;
        for (int x = 0; x != m; ++x) {
            y0 |= matrix[x][0] == 0;
        }

        for (int x = 1; x < m; ++x) {
            for (int y = 1; y < n; ++y) {
                if (matrix[x][y] == 0) {
                    matrix[x][0] = 0;
                    matrix[0][y] = 0;
                }
            }
        }

        for (int x = 1; x < m; ++x) {
            if (matrix[x][0] == 0) {
                for (int y = 1; y < n; ++y) {
                    matrix[x][y] = 0;
                }
            }
        }
        for (int y = 1; y < n; ++y) {
            if (matrix[0][y] == 0) {
                for (int x = 1; x < m; ++x) {
                    matrix[x][y] = 0;
                }
            }
        }

        if (x0) {
            for (int y = 0; y != n; ++y) {
                matrix[0][y] = 0;
            }
        }
        if (y0) {
            for (int x = 0; x != m; ++x) {
                matrix[x][0] = 0;
            }
        }
    }
}
