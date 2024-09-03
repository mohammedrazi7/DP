import java.util.Scanner;

public class Solution4 {
    public static boolean canPartition(int[] nums) {
        // int s = Arrays.stream(nums).sum();
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        if (s % 2 == 1) {
            return false;
        }
        int n = nums.length;
        int m = s >> 1;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; ++j) {
                f[i][j] = f[i - 1][j] || (j >= x && f[i - 1][j - x]);
            }
        }
        return f[n][m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Input the elements of the array
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Create an instance of Solution and call the canPartition method
        Solution4 solution = new Solution4();
        boolean result = solution.canPartition(nums);

        // Output the result
        System.out.println("Can partition into two subsets with equal sum: " + result);
    }
}
