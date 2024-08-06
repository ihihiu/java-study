import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] visited;
    public void DFS(int v){
        if (v == n) answer++;
        else{
            for (int i = 1; i <= n; i++){
                if (graph[v][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    DFS(i);
                    visited[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++){
            graph[kb.nextInt()][kb.nextInt()] = 1;
        }
        visited[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
