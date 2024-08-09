import java.util.*;

public class Main {
    static int c, n, answer = 0;
    static int[] arr;
    public void DFS(int depth, int sum){
        if (sum > c) return;
        if (depth == n){
            if (sum > answer){
                answer = sum;
            }
        }
        else{
            DFS(depth + 1, sum + arr[depth]);
            DFS(depth + 1, sum);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
