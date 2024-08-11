import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    public void DFS(int depth, int n, int m, Integer[] arr, int sum){
        if (depth >= answer) return;
        if (sum > m) return;
        if (sum == m) answer = depth;
        else {
            for (int i = 0; i < n; i++){
                DFS(depth + 1, n, m, arr, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int m = kb.nextInt();
        T.DFS(0, n, m, arr, 0);
        System.out.println(answer);
    }
}
