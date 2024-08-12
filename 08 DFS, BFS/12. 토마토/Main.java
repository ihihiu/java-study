import java.util.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] graph;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public void BFS() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        graph = new int[n][m];
        boolean allRipen = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = kb.nextInt();
                graph[i][j] = x;
                if (x == 1) queue.offer(new Point(i, j));
                if (x == 0) allRipen = false;
            }
        }
        if (allRipen) System.out.println(0);
        else {
            T.BFS();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 0) flag = false;
                }
            }
            if (flag) System.out.println(answer - 1);
            else System.out.println(-1);
        }
    }
}
