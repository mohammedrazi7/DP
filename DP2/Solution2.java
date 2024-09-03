import java.util.Scanner;

public class Solution2 {
    public static int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int len = nums.length;
        if(1 == len) return nums[0];
        int result = 0;
        int[] dp = new int[len + 1];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + (i >= 2 ? dp[i - 2] : 0));
        }
        int[] dp1 = new int[len + 1];
        for(int i = 2; i <= len; i++){
            dp1[i] = Math.max(dp1[i - 1], nums[i - 1] + dp1[i - 2]);
        }
        return Math.max(dp[len - 1], dp1[len]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of houses
        System.out.print("Enter the number of houses: ");
        int n = sc.nextInt();

        // Input the amount of money in each house
        int[] nums = new int[n];
        System.out.println("Enter the money in each house: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Create an instance of Solution and call the rob method
        Solution2 solution = new Solution2();
        int result = solution.rob(nums);

        // Output the result
        System.out.println("Maximum amount that can be robbed: " + result);
    }
}
