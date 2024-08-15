import java.util.*;

class Main{
    public int solution(int n){
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 2; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n + 1];
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}