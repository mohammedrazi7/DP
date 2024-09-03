import java.util.Scanner;

class Solution5{

    // Utility function to find minimum sum for a path
    static int helper(int A[][], int i, int j) {
        // Base Case
        if (i == A.length) {
            return 0;
        }

        // Add current value to the minimum of the next paths
        return A[i][j] + Math.min(helper(A, i + 1, j), helper(A, i + 1, j + 1));
    }

    // Function to return the minimum path sum
    static int minSumPath(int A[][]) {
        return helper(A, 0, 0);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of rows
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Initialize the triangle
        int[][] triangle = new int[rows][];

        // Input the triangle values
        System.out.println("Enter the triangle values row by row:");
        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        // Calculate and print the minimum sum path
        System.out.println("Minimum path sum: " + minSumPath(triangle));
    }
}
