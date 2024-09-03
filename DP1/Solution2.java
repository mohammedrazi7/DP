import java.util.Scanner;

class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int ft = 0; // T(0)
        int st = 1; // T(1)
        int tt = 1; // T(2)

        // Loop starts from 3 as the first 3 values are initialized
        for (int i = 3; i <= n; i++) {
            int next = ft + st + tt;
            ft = st;
            st = tt;
            tt = next;
        }

        return tt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of n
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.tribonacci(n);

        // Output the result
        System.out.println("Tribonacci number at index " + n + " is: " + result);
    }
}
