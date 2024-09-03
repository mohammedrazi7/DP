import java.util.Scanner;

public class Solution1 {

    // Function to count the number of ways to reach the top
    static int countWays(int n, int m) {
        // dp[i] will store the number of ways to reach the i-th stair
        int[] dp = new int[n + 1];
        dp[0] = 1; // There's one way to stay at the ground (doing nothing)

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= m && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of stairs (n)
        System.out.print("Enter the total number of stairs (n): ");
        int n = scanner.nextInt();

        // Input the maximum number of stairs that can be climbed at once (m)
        System.out.print("Enter the maximum number of stairs that can be climbed at once (m): ");
        int m = scanner.nextInt();

        // Calculate the number of ways to reach the top
        int result = countWays(n, m);

        // Output the result
        System.out.println("Number of ways to reach the top: " + result);
    }
}
