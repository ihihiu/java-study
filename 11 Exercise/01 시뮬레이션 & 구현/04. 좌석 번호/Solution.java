import java.util.*;
class Solution {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if (k > c * r) return new int[] {0, 0};
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] graph = new int[r][c];
        int x = 0, y = 0, d = 0, cnt = 1;
        graph[x][y] = 1;
        while (cnt < k){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && graph[nx][ny] == 0){
                cnt++;
                graph[nx][ny] = 1;
                x = nx;
                y = ny;
            }
            else{
                d = (d + 1) % 4;
            }
        }
        answer[0] = y + 1;
        answer[1] = x + 1;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}