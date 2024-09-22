import java.util.*;

class Point{
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] board){
        int[][] ch = new int[7][7];
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        queue.offer(new Point(0, 0));
        ch[0][0] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                for (int j = 0; j < 4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (nx == 6 && ny == 6) return L + 1;
                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && ch[nx][ny] == 0 && board[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }

}