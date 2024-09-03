import java.util.Scanner;

public class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of houses: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the amount of money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution3 solution = new Solution3();
        int result = solution.rob(nums);

        System.out.println("Maximum amount of money that can be robbed: " + result);
    }
}
