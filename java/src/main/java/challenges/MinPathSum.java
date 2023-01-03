package challenges;

import org.junit.Test;

import java.util.Arrays;

public class MinPathSum {


    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     */

    @Test
    public void test() {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        minPathSum2(grid);
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int leftSum = (j > 0) ? grid[i][j - 1] : Integer.MAX_VALUE;
                int topSum = (i > 0) ? grid[i - 1][j] : Integer.MAX_VALUE;
                if (i == 0 && j == 0) continue;

                grid[i][j] += Math.min(leftSum, topSum);
            }
        }
        return grid[row - 1][col - 1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int row[] : dp)
            Arrays.fill(row, -1); //initializing the dp array
        dp[0][0] = grid[0][0]; // first base case
        for (int i = 1; i < m; i++) dp[i][0] = grid[i][0] + dp[i - 1][0]; //second base case.
        for (int i = 1; i < n; i++) dp[0][i] = grid[0][i] + dp[0][i - 1]; //second base case.

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                int left = grid[i][j] + dp[i][j - 1];
                int up = grid[i][j] + dp[i - 1][j];
                dp[i][j] = Math.min(left, up);
            }
        }
        return dp[m - 1][n - 1];
    }
}

