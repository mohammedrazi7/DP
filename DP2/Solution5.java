import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {
    public int coinChange(int[] coins, int amount) {
        final int inf = 1 << 30;
        int m = coins.length;
        int n = amount;
        int[][] f = new int[m + 1][n + 1];
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1]) {
                    f[i][j] = Math.min(f[i][j], f[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return f[m][n] >= inf ? -1 : f[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of coin denominations
        System.out.print("Enter the number of different coins: ");
        int m = sc.nextInt();

        // Input the coin denominations
        int[] coins = new int[m];
        System.out.println("Enter the coin denominations: ");
        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextInt();
        }

        // Input the amount
        System.out.print("Enter the amount: ");
        int amount = sc.nextInt();

        // Create an instance of Solution and call the coinChange method
        Solution5 solution = new Solution5();
        int result = solution.coinChange(coins, amount);

        // Output the result
        System.out.println("Minimum number of coins needed: " + (result == -1 ? "Not possible" : result));
    }
}
