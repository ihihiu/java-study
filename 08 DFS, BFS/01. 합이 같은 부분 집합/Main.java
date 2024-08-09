import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static String answer = "NO";
    boolean flag = false;
    public void DFS(int depth, int sum1, int sum2){
        if (flag) return;
        if (depth == n){
            if (sum1 == sum2){
                answer = "YES";
                flag = true;
            }
        }
        else{
            DFS(depth + 1, sum1 + arr[depth], sum2);
            DFS(depth + 1, sum1, sum2 + arr[depth]);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
