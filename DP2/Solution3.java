import java.util.Scanner;

public class Solution3 {
    public static int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int[][] f=new int[grid.length][grid[0].length];
        f[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++) f[i][0]=f[i-1][0]+grid[i][0];
        for(int j=1;j<grid[0].length;j++) f[0][j]=f[0][j-1]+grid[0][j];
        for(int i=1;i<grid.length;i++)
            for(int j=1;j<grid[0].length;j++)
                f[i][j]=Math.min(f[i-1][j],f[i][j-1])+grid[i][j];
        return f[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of rows and columns in the grid
        System.out.print("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n = sc.nextInt();

        // Input the grid values
        int[][] grid = new int[m][n];
        System.out.println("Enter the grid values: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Create an instance of Solution and call the minPathSum method
        Solution3 solution = new Solution3();
        int result = solution.minPathSum(grid);

        // Output the result
        System.out.println("Minimum Path Sum: " + result);
    }
}
