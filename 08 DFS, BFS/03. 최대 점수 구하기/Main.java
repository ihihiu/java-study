import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static int[][] arr;
    public void DFS(int depth, int time, int score){
        if (time > m) return;
        if (depth == n) answer = Math.max(answer, score);
        else {
            DFS(depth + 1, time + arr[depth][1], score + arr[depth][0]);
            DFS(depth + 1, time, score);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
