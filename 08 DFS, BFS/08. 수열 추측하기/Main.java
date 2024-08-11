import java.util.*;

public class Main {
    static int n, f;
    static int[] b, p, ch;
    int[][] dp = new int[35][35];

    public int combi(int n, int r){
        if (dp[n][r] > 0) return dp[n][r];
        if (r == 0 || r == n) return 1;
        else return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int depth, int sum) {
        if (depth == n) {
            if (sum == f) {
                for (int x : p) System.out.print(x + " ");
                System.exit(0);
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[depth] = i;
                    DFS(depth + 1, sum + (p[depth] * b[depth]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) b[i] = T.combi(n - 1, i);
        T.DFS(0, 0);
    }
}
