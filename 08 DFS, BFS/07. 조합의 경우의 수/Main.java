import java.util.*;

public class Main {
    int[][] dp = new int[35][35];
    public int DFS(int n, int r){
        if (dp[n][r] > 0) return dp[n][r];
        if (r == 0 || r == n) return 1;
        else return dp[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);

    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
