import java.util.*;

class Main{
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n]);
    }
}