import java.util.*;

class Point{
    public int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] graph, distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        graph[x][y] = 1;
        while (!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && graph[nx][ny] == 0){
                    graph[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    distance[nx][ny] = distance[now.x][now.y] + 1;

                }
            }
        }
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        graph = new int[7][7];
        distance = new int[7][7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                graph[i][j] = kb.nextInt();
            }
        }
        T.BFS(0, 0);
        if (distance[6][6] == 0) System.out.println(-1);
        else System.out.println(distance[6][6]);
    }
}
