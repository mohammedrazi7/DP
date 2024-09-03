import java.util.Scanner;

public class Solution1 {
    private int[][] obstacleGrid;
    private Integer[][] f;
    private int m;
    private int n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions of the grid
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        // Input the grid
        int[][] obstacleGrid = new int[m][n];
        System.out.println("Enter the grid (0 for free space, 1 for obstacle): ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = sc.nextInt();
            }
        }

        // Create an instance of Solution and call the method
        Solution1 solution = new Solution1();
        int result = solution.uniquePathsWithObstacles(obstacleGrid);

        // Output the result
        System.out.println("Number of unique paths: " + result);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        f = new Integer[m][n];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (f[i][j] == null) {
            f[i][j] = dfs(i + 1, j) + dfs(i, j + 1);
        }
        return f[i][j];
    }
}
