import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};


    public void DFS(int x, int y){
        for (int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == 1){
                graph[nx][ny] = 0;
                DFS(nx, ny);
            }
        }

    }
    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        graph = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                graph[i][j] = kb.nextInt();
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (graph[i][j] == 1){
                    graph[i][j] = 0;
                    T.DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
